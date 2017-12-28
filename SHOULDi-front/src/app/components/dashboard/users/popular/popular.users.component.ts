import { Component } from "@angular/core";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { UserService } from "../../../../services/user.service";
import { User } from "../../../../models/user";

@Component({
    selector: "popular-users",
    templateUrl: "./popular.users.component.html",
    styleUrls: ["./popular.users.component.css"]
})

@AutoUnsubscribe
export class PopularUsersComponent{
    popularUsers : User[];
    constructor (private userService : UserService)
    {
        
        // TODO: implement this    
    }
}