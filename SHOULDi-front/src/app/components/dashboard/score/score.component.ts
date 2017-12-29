import { Component } from "@angular/core";
import { UserService } from "../../../services/user.service";

@Component({
    selector    : 'score',
    templateUrl : './score.component.html',
    styleUrls   : [
        './score.component.css'
    ] 
})

export class ScoreComponent {
    score : any;
    likes : any[];
    dislikes : any[];
    data : any;
    // TODO : provide functionality to score.component.html here
    constructor(private userService : UserService){
        this.userService.getScoreByUser(JSON.parse(localStorage.getItem("currentUser"))).subscribe(data => this.data = data);
    }

    
}