import { Component } from "@angular/core";
import { UserService } from "../../../../services/user.service";
import { User } from "../../../../models/user";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { Response } from "@angular/http/src/static_response";

@Component({
    selector: "flagged-users",
    templateUrl: "./flagged.users.component.html",
    styleUrls: ["./flagged.users.component.css"]
})

@AutoUnsubscribe
export class FlaggedUsersComponent{
    flaggedUsers : User[];

    constructor(private userService : UserService)
    {
        // TODO: check this with the endpoint that Xavier,Caleb come up with     
        userService.getFlaggedUsers().subscribe(users => {
            this.flaggedUsers = users;
        })
    }
}