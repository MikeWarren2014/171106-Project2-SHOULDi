import { Component,OnInit } from "@angular/core";
import { Post } from "../../../models/post";
import { User } from "../../../models/user"

import { PostService } from "../../../services/post.service";
import { UserService } from "../../../services/user.service"
import { AutoUnsubscribe } from "../../../autoUnsubscribe";

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
    hasUpvoted   : boolean[];
    hasDownvoted : boolean[];
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
        this.postService.delete(post);
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
                // for right now, hasUpvoted,hasDownvoted assumed all false all across the board
                this.hasUpvoted  = new Array(posts.length).fill(false);
                this.hasDownvoted= new Array(posts.length).fill(false);
            } 

        });
    }
    /**
     * Advances to, and returns, next image, if there is one, or last image. 
     */
    nextImage()
    {
        if (this.postIndex < this.posts.length - 1) return (this.currentPost = this.posts[++this.postIndex]);
        this.postIndex = this.posts.length - 1;
        return (this.currentPost = this.posts[this.posts.length - 1]);
    }
    /**
     * Goes back to, and returns, previous image, if there is one, or first image.
     */
    prevImage()
    {
        if (this.postIndex >= 1) return (this.currentPost = this.posts[--this.postIndex]);
        this.postIndex = 0;
        return (this.currentPost = this.posts[0]); 
    }

    upvote()
    {
        // client-side mock for right now
        this.hasUpvoted[this.postIndex] = true;
        this.currentPost[this.postIndex].likes++;
        // TODO: implement this
    }

    downvote()
    {
        // client-side mock for right now
        this.hasDownvoted[this.postIndex] = true;
        this.currentPost[this.postIndex].dislikes++;
        // TODO: implement this
    }

    comment()
    {
        // TODO: implement this
    }
}