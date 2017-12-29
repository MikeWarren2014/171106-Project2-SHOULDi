import { Component } from "@angular/core";
import { Post } from "../../../../models/post";
import { PostService } from "../../../../services/post.service";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";

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


    constructor(private postService : PostService){
    }

    ngOnInit() {
        if (localStorage.getItem("currentUser"))
        {
            this.postService.getPostsFromUser(JSON.parse(localStorage.getItem("currentUser")))
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
    ngOnDestroy() {
        //Called once, before the instance is destroyed.
        //Add 'implements OnDestroy' to the class.
        
    }
}