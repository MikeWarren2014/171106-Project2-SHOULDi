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
    popularUsers : any[];
    currentUser : string;
    currentIndex : number;
    data : any;
    constructor (private userService : UserService)
    {
        
        // TODO: implement this    
    }

    ngOnInit() {
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        this.userService.getHighScoreUsers().subscribe(
            data => {
                this.popularUsers = JSON.parse(data)
                if(this.popularUsers[0].userEmail){
                    this.currentUser = this.popularUsers[0].userEmail;
                } else {
                    this.currentUser = null;
                }
            }
        );
    }
}