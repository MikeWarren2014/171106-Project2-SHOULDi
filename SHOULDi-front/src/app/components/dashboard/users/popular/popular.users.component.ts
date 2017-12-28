import { Component } from "@angular/core";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { UserService } from "../../../../services/user.service";

@Component({
    selector: "popular-users",
    templateUrl: "./popular.users.component.html",
    styleUrls: ["./popular.users.component.css"]
})

@AutoUnsubscribe
export class PopularUsersComponent{
    // TODO: implement this    
    
    constructor (private userService : UserService)
    {
        
    }
}