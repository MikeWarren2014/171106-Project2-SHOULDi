import { Component } from "@angular/core";
import { PostService } from "../../../services/post.service";

@Component({
    selector    : 'score',
    templateUrl : './score.component.html',
    styleUrls   : [
        './score.component.css'
    ] 
})

export class ScoreComponent {
    likes : any[];
    dislikes : any[];
    // TODO : provide functionality to score.component.html here
    constructor(private postService : PostService){
        this.postService.g
    }
}