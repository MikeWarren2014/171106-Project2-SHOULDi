import { Component } from "@angular/core";
import { UserService } from "../../../../services/user.service";
import { User } from "../../../../models/user";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { FlaggedPostsComponent } from "../../posts/flagged/flagged.posts.component";
import { FlaggedCommentsComponent } from "../../comments/flagged/flagged.comments.component";

@Component({
    selector: "flagged-users",
    templateUrl: "./flagged.users.component.html",
    styleUrls: ["./flagged.users.component.css"]
})

@AutoUnsubscribe
export class FlaggedUsersComponent{
    flaggedUsers : any[];
    flaggedUser : any;

    constructor(){
        
    }

    viewFlaggedPosts(user : any){
        
    }

    viewFlaggedComments(user : any)
    {
        this.flaggedUser = user;
    }
}
