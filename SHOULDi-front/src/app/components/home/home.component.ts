import { Component,OnInit } from "@angular/core";
import { User } from "../../models/user"
import { ActivatedRoute } from "@angular/router";
import { ViewChild } from "@angular/core";
import { BannerComponent } from "../dashboard/banner/banner.component";

@Component({
    selector   : 'home',
    templateUrl: './home.component.html'
})

export class HomeComponent
{

    @ViewChild(BannerComponent) banner : BannerComponent;
    
    constructor(private route : ActivatedRoute){

    }

    
}