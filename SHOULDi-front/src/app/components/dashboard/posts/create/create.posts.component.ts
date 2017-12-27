import { Component } from "@angular/core";
import { PostService } from "../../../../services/post.service";
import { Post } from "../../../../models/post";

@Component({
    selector    : 'create-posts',
    templateUrl : './create.posts.component.html',
    styleUrls   : [
        './create.posts.component.css'
    ] 
})

export class CreatePostsComponent {
    public post         : Post;
    public postImage    : File;
    public blobImage    : Blob;
    public image        : any;
    public reader       : FileReader;
    public isImageLoading: boolean;
    public message      : any;
    constructor(private postService : PostService){
        this.post = new Post();
    }
    public createPost(){
        this.postImage = (<HTMLInputElement>document.getElementById("postImage")).files[0];
        this.blobImage = this.postImage;
        this.reader = new FileReader();
        this.reader.onload = () => {
            this.image = this.reader.result;
            this.post.image = btoa(this.image);
            this.image = atob(this.post.image);
            this.post.postDate = new Date();
            console.log(this.image);
            console.log(this.postService.create(this.post).subscribe(message => this.message = message));
        };
        this.reader.readAsDataURL(this.blobImage);
    }
}