import { Component } from "@angular/core";


@Component({
    selector    : 'banner',
    templateUrl : './banner.component.html',
    styleUrls   : [
        './banner.component.css'
    ]
})

export class BannerComponent
{
    public visible = false;

    public toggleVisible() {
        this.visible = !this.visible;
    }
}