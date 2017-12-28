import { Component } from "@angular/core";
import { UserService } from "../../../../services/user.service";
import { User } from "../../../../models/user";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";

@Component({
    selector: "flagged-users",
    templateUrl: "./flagged.users.component.html",
    styleUrls: ["./flagged.users.component.css"]
})

@AutoUnsubscribe
export class FlaggedUsersComponent{

}
