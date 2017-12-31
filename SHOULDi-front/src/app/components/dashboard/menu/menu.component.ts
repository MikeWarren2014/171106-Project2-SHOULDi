import { Component } from "@angular/core";
import { User } from "../../../models/user";
import { UserRoles } from "../../../models/userRoles";

@Component({
    selector    : 'menu',
    templateUrl : './menu.component.html',
    styleUrls   : [
        './menu.component.css'
    ]
})

export class MenuComponent
{
    currentUser : User;
    TEST : number = 1;
    constructor(){
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        console.log(this.currentUser);
    }
}