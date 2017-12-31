import { Component } from '@angular/core';
import { Advertisement } from '../../../../models/advertisement';
import { AdvertisementService } from '../../../../services/advertisement.service';

@Component({
    selector: 'create-advertisements',
    templateUrl: 'create.advertisements.component.html',
    styleUrls: ['create.advertisements.component.css']
})

export class CreateAdvertisementsComponent{
    public post         : Advertisement;
    public postImage    : File;
    public blobImage    : Blob;
    public image        : any;
    public reader       : FileReader;
    public isImageLoading: boolean;
    public data           : any;
    constructor(private postService : AdvertisementService){
        this.post = new Advertisement();
    }
    public createPost(){
        this.postImage = (<HTMLInputElement>document.getElementById("postImage")).files[0];
        this.blobImage = this.postImage;
        this.reader = new FileReader();
        this.reader.onload = () => {
            this.image = this.reader.result;
            this.post.image =this.reader.result; 

            this.post.postDate = new Date();
            console.log(this.image);
            console.log(this.postService.create(this.post).subscribe(data => this.data = data));
        };
        this.reader.readAsDataURL(this.blobImage);
    }
}