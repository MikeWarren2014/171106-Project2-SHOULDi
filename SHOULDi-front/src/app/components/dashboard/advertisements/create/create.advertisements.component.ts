import { Component } from '@angular/core';
import { Advertisement } from '../../../../models/advertisement';
import { AdvertisementService } from '../../../../services/advertisement.service';

@Component({
    selector: 'create-advertisements',
    templateUrl: 'create.advertisements.component.html',
    styleUrls: ['create.advertisements.component.css']
})

export class CreateAdvertisementsComponent{
    public advertisement  : Advertisement;
    public postImage    : File;
    public blobImage    : Blob;
    public image        : any;
    public reader       : FileReader;
    public isImageLoading: boolean;
    public data           : any;
    constructor(private postService : AdvertisementService){
        this.advertisement = new Advertisement();
    }
    public createAdvertisement(){
        this.postImage = (<HTMLInputElement>document.getElementById("advertisementImage")).files[0];
        this.blobImage = this.postImage;
        this.reader = new FileReader();
        this.reader.onload = () => {
            this.image = this.reader.result;
            this.advertisement.image =this.reader.result; 
            
            this.advertisement.postDate = new Date();
            console.log(this.image);
            console.log(this.postService.create(this.advertisement).subscribe(data => this.data = data));
        };
        this.reader.readAsDataURL(this.blobImage);
    }
}