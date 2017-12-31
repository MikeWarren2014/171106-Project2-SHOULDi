import { Component,OnInit } from "@angular/core";
import { Post } from "../../../models/post";
import { User } from "../../../models/user"
import { TestData } from "../../../test/test.data";

import { PostService } from "../../../services/post.service";
import { UserService } from "../../../services/user.service"
import { AutoUnsubscribe } from "../../../autoUnsubscribe";
import { Comment } from "../../../models/comment";
import { Response } from "@angular/http/src/static_response";

@Component({
    selector   : 'feed',
    templateUrl: './feed.component.html',
    styleUrls  : [
        './feed.component.css'
    ]
})

@AutoUnsubscribe
export class FeedComponent
{
    private USE_MOCK_DATA : boolean = false;
    // a feed has a logged on user
    currentUser: User;
    // since this component will only have one post at a time, it has currentPost, too
    currentPost: Post;
    // a feed has posts
    posts: Post[] = []; 
    postIndex = 0;
    // the comment the user is typing
    newComment = {
        _id: null,
        commenter : <User>(JSON.parse(localStorage.getItem("currentUser"))),
        content   : '',
        isFlagged : false
    };
    // whether or not the user has commented
    hasCommented = false;

    constructor(private userService: UserService,
        private postService : PostService
    )
    {
        if (!this.USE_MOCK_DATA)
        {
            this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        }
        else
        {
            this.currentUser = new User("mwarren", "Mike", "warren", "mwarren@ayhoo.com", 50);
        }
    }

    ngOnInit() {
        if (!this.USE_MOCK_DATA)
        {
            this.loadPosts();
        }
        else 
        {
            this.posts = TestData.posts;
            this.currentPost = this.posts[0];
        }
    }

    /**
     * Loads posts and instantiates currentPost
     */
    private loadPosts() {
        this.postService.getSomeFeed().subscribe(posts => { 
            console.log("Loading new posts:");
            //console.log("posts == %s", JSON.stringify(posts, null, '\t'));
            this.posts = posts; 
            //console.log("this.posts == %s", JSON.stringify(this.posts, null, '\t'));
            if (posts) {
                // instantiate currentPost
                this.currentPost = posts[0];
                return true;
            } else {
                return false;
            }
        });
    }

    /**
     * Advances to, and returns, next image, if there is one, or null.
     */
    nextImage()
    {
        console.log("Getting next image:");
        this.newComment.content = '';
        if (this.postIndex < this.posts.length - 1){
            this.posts[this.postIndex] = null;
            return this.posts[++this.postIndex];
        } 
        this.postIndex = this.posts.length - 1;
        return null;
    }
    
    /**
     * Goes back to, and returns, previous image, if there is one, or first image.
     */
    prevImage()
    {
        this.newComment.content = '';
        if (this.postIndex >= 1) return this.posts[--this.postIndex];
        this.postIndex = 0;
        return (this.currentPost = this.posts[0]); 
    }

    upvote()
    {
        this.postService.like(this.currentPost, this.newComment);
        // try to load next post
        let nextPost = this.nextImage();
        // if there was no next post to load, load in more posts (from the server)
        if (!nextPost)
        {
            if(!this.loadPosts()){
                this.posts = [];
            }
        } else {
            this.currentPost = nextPost;
        }
        this.hasCommented = false;
    }
    
    downvote()
    {
        this.postService.dislike(this.currentPost, this.newComment);
        // try to load next post
        let nextPost = this.nextImage();
        // if there was no next post to load, load in more posts (from the server)
        if (!nextPost)
        {
            if(!this.loadPosts()){
                this.posts = [];
            }
        } else {
            this.currentPost = nextPost;
        }
        this.hasCommented = false;
    }

    comment()
    {
        // TODO: make call to server
        // client-side functionality
        this.hasCommented = true;
    }

    flagPost(post)
    {
        console.log("Flagging Post");
        this.postService.flagPost(post).map((res : Response) => {
            let message = res.json().message.toString().toUpperCase();
            console.log(message);
            if (message === "SUCCESS")
            {
                post.isFlagged = true;
                // advance to next image
                let nextPost = this.nextImage();
                if (!nextPost)
                {
                    this.loadPosts();
                }
            }
            else if (message === "FAILURE")
            {
                // TODO: error handling
            }
        })
    }
}