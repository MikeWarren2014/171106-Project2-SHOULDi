import { Component,OnInit } from "@angular/core";
import { User } from "../../models/user"
import { ActivatedRoute } from "@angular/router";

@Component({
    selector   : 'home',
    templateUrl: './home.component.html'
})

export class HomeComponent
{

    constructor(private route : ActivatedRoute){

    }

}