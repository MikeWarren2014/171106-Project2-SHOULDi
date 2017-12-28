import { Component } from "@angular/core";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { UserService } from "../../../../services/user.service";
import { User } from "../../../../models/user";

@Component({
    selector: "locked-users",
    templateUrl: "./locked.users.component.html",
    styleUrls: ["./locked.users.component.css"]
})

@AutoUnsubscribe
export class LockedUsersComponent{
    lockedUsers : User[];
    constructor(private userService : UserService)
    {
        
        // TODO: implement this    
    }
}