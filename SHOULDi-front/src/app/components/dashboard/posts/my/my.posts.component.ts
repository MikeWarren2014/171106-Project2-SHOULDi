import { Component } from "@angular/core";
import { Post } from "../../../../models/post";
import { PostService } from "../../../../services/post.service";

@Component({
    selector    : 'my-posts',
    templateUrl : './my.posts.component.html',
    styleUrls   : [
        './my.posts.component.css'
    ] 
})

export class MyPostsComponent {
    posts : Post[];
    message : any;
    constructor(private postService : PostService){
    }

    ngOnInit() {
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        console.log(this.postService.getPostsFromUser(JSON.parse(localStorage.getItem("currentUser"))).subscribe(message => this.message = message));

        //TODO: need to store posts to display 

    }

    ngOnDestroy() {
        //Called once, before the instance is destroyed.
        //Add 'implements OnDestroy' to the class.
        
    }
}