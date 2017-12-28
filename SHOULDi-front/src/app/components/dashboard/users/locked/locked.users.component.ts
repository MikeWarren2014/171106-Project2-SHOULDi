import { Component } from "@angular/core";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { UserService } from "../../../../services/user.service";

@Component({
    selector: "locked-users",
    templateUrl: "./locked.users.component.html",
    styleUrls: ["./locked.users.component.css"]
})

@AutoUnsubscribe
export class LockedUsersComponent{
    constructor(private userService : UserService)
    {
        
    }
}