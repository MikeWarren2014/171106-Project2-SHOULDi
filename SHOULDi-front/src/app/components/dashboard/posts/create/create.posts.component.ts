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
    constructor(private postService : PostService){
        this.post = new Post();
    }
    public createPost(){
        this.postImage = (<HTMLInputElement>document.getElementById("postImage")).files[0];
        this.blobImage = this.postImage;
        this.reader = new FileReader();
        this.reader.onload = () => { this.image = this.reader.result;};
        this.reader.readAsDataURL(this.blobImage);
        this.post.image = this.image;
        this.post.postDate = new Date();
        
        this.postService.create(this.post);
    }
}