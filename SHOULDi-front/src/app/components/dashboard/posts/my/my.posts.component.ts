import { Component } from "@angular/core";
import { Post } from "../../../../models/post";
import { PostService } from "../../../../services/post.service";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { Comment } from "../../../../models/comment";
import { CommentService } from "../../../../services/comment.service";
import { Response } from "@angular/http/src/static_response";

@Component({
    selector    : 'my-posts',
    templateUrl : './my.posts.component.html',
    styleUrls   : [
        './my.posts.component.css'
    ] 
})

@AutoUnsubscribe
export class MyPostsComponent {
    posts : Post[] = [];
    currentPost : Post;
    message : any;

    // a feed has posts
    postIndex = 0;


    constructor(private postService : PostService, 
        private commentService : CommentService){
    }

    ngOnInit() {
        if (localStorage.getItem("currentUser"))
        {
            this.postService.getAllPostsByUser(JSON.parse(localStorage.getItem("currentUser")))
                // .subscribe(message => this.message = message);
                .subscribe(posts => {
                    this.posts = posts
                    if (posts) {
                        // instantiate currentPost
                        this.currentPost = posts[0];
                    }
                });
        }
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
    
    flagComment(comment : Comment)
    {
        this.commentService.flagComment(comment).map((res : Response) => {
            let message = res.json().message.toString().toUpperCase();
            if (message === "SUCCESS")
            {
                comment.isFlagged = true;
            }
            else if (message === "FAILURE")
            {
                // TODO: error handling
            }
        })
    }
}