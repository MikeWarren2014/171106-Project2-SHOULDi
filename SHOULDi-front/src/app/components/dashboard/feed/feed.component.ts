import { Component,OnInit } from "@angular/core";
import { Post } from "../../../models/post";
import { User } from "../../../models/user"

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
    // a feed has a logged on user
    currentUser: User;
    // since this component will only have one post at a time, it has currentPost, too
    currentPost: Post;
    users: User[] = []; // does a feed have users?
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
        private postService : PostService)
    {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
    ngOnInit() {
        this.loadPosts();
    }

    // why is this here?
    deletePost(post : Post)
    {
        this.postService.deletePost(post);
    }
    /**
     * Loads posts and instantiates currentPost
     */
    private loadPosts() {
        this.postService.getSomeFeed().subscribe(posts => { 
            this.posts = posts; 
            if (posts) {
                // instantiate currentPost
                this.currentPost = posts[0];
            } 

        });
    }
    /**
     * Advances to, and returns, next image, if there is one, or null.
     */
    nextImage()
    {
        this.newComment.content = '';
        if (this.postIndex < this.posts.length - 1) return (this.currentPost = this.posts[++this.postIndex]);
        this.postIndex = this.posts.length - 1;
        this.currentPost = this.posts[this.posts.length - 1];
        return null;
    }
    /**
     * Goes back to, and returns, previous image, if there is one, or first image.
     */
    prevImage()
    {
        this.newComment.content = '';
        if (this.postIndex >= 1) return (this.currentPost = this.posts[--this.postIndex]);
        this.postIndex = 0;
        return (this.currentPost = this.posts[0]); 
    }

    upvote()
    {
        this.postService.like(this.currentPost);
        // try to load next post
        let nextPost = this.nextImage();
        // if there was no next post to load, load in more posts (from the server)
        if (!nextPost)
        {
            this.loadPosts();
        }
    }
    
    downvote()
    {
        
        this.postService.dislike(this.currentPost);
        // try to load next post
        let nextPost = this.nextImage();
        // if there was no next post to load, load in more posts (from the server)
        if (!nextPost)
        {
            this.loadPosts();
        }
    }

    comment()
    {
        // TODO: make call to server
        // client-side functionality
        this.hasCommented = true;
    }

    flagPost(post)
    {
        this.postService.flagPost(post).map((res : Response) => {
            let message = res.json().message.toString().toUpperCase();
            if (message === "SUCCESS")
            {
                post.isFlagged = true;
                //TODO : advance to next image
            }
            else if (message === "FAILURE")
            {
                // TODO: error handling
            }
        })
    }
}