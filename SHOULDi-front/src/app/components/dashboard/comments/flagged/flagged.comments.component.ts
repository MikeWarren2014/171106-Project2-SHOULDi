import { Component, Input } from "@angular/core";
import { User } from "../../../../models/user";

@Component({
    selector: "flagged-comments",
    templateUrl: "flagged.comments.component.html",
    styleUrls: ["flagged.comments.component.css"]
})

export class FlaggedCommentsComponent{
    @Input() user : User;
    constructor(){
        
    }
}