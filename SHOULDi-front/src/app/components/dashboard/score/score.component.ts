import { Component } from "@angular/core";
import { UserService } from "../../../services/user.service";
import { AutoUnsubscribe } from "../../../autoUnsubscribe";
@Component({
    selector    : 'score',
    templateUrl : './score.component.html',
    styleUrls   : [
        './score.component.css'
    ] 
})

@AutoUnsubscribe
export class ScoreComponent {
    score : any;
    likes : any[];
    dislikes : any[];
    data : any;
    // TODO : provide functionality to score.component.html here
    constructor(private userService : UserService){
        // console.log(this.userService.getScoreByUser(JSON.parse(localStorage.getItem("currentUser"))).subscribe(data => this.data = data));
        // console.log(this.userService.getLikesByUser(JSON.parse(localStorage.getItem("currentUser"))).subscribe(data => this.data = data));
        // console.log(this.userService.getDislikesByUser(JSON.parse(localStorage.getItem("currentUser"))).subscribe(data => this.data = data));
    }
}