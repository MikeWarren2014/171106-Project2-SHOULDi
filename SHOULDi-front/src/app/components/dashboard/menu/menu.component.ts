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
    public BASE_USER : string;
    public MODERATOR : string;
    public SPONSOR : string;
    currentUser : User = JSON.parse(localStorage.getItem('currentUser'));
    TEST : number = 1;

    constructor()
    {
        this.BASE_USER = UserRoles.BASE_USER;
        this.MODERATOR = UserRoles.MODERATOR;
        this.SPONSOR = UserRoles.SPONSOR;
    }
}