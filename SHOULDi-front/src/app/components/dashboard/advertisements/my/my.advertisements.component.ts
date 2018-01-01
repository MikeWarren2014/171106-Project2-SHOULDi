import { Component } from '@angular/core';
import { Advertisement } from '../../../../models/advertisement';
import { AdvertisementService } from '../../../../services/advertisement.service';

@Component({
    selector: 'my-advertisements',
    templateUrl: 'my.advertisements.component.html',
    styleUrls: ['my.advertisements.component.css']
})

export class MyAdvertisementsComponent{
    advertisements : any[];
    currentAdvertisement : any;

    // a feed has advertisements
    advertisementIndex = 0;


    constructor(private advertisementService : AdvertisementService){
    }

    ngOnInit() {
        if (localStorage.getItem("currentUser"))
        {
            this.advertisementService.getAllAdvertisementsByUser(JSON.parse(localStorage.getItem("currentUser")))
                // .subscribe(message => this.message = message);
                .subscribe(data => {
                    // this.advertisements = JSON.parse(data);
                    console.log("data.length == " + data.length)
                    this.advertisements = data;
                    if (this.advertisements) {
                        // instantiate currentAdvertisement
                        this.currentAdvertisement = this.advertisements[0];
                    }
                });
        }
    }

    /**
     * Advances to, and returns, next image, if there is one, or last image. 
     */
    nextImage()
    {
        if (this.advertisementIndex < this.advertisements.length - 1) return (this.currentAdvertisement = this.advertisements[++this.advertisementIndex]);
        this.advertisementIndex = this.advertisements.length - 1;
        return (this.currentAdvertisement = this.advertisements[this.advertisements.length - 1]);
    }
    /**
     * Goes back to, and returns, previous image, if there is one, or first image.
     */
    prevImage()
    {
        if (this.advertisementIndex >= 1) return (this.currentAdvertisement = this.advertisements[--this.advertisementIndex]);
        this.advertisementIndex = 0;
        return (this.currentAdvertisement = this.advertisements[0]); 
    }
}