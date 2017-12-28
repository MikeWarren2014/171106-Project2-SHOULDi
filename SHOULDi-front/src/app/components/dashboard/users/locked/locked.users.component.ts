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
        // TODO: check this with the endpoint that Xavier,Caleb come up with     
        userService.getLockedUsers().subscribe(users => {
            this.lockedUsers = users;
        }) 
    }

    unlockUser(user : User)
    {
        // this.userService.
        // TODO: hit "unlock" endpoint
    }
}