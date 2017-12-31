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
    constructor(public UserRoles : UserRoles)
    {

    }
    currentUser : User = JSON.parse(localStorage.getItem('currentUser'));
    IS_TEST : boolean = true;
}