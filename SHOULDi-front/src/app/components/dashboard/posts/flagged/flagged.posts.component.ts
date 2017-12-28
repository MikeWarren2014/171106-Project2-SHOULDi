import { Component, Input } from "@angular/core";
import { PostService } from "../../../../services/post.service";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";
import { User } from "../../../../models/user";

@Component({
    selector    : 'flagged-posts',
    templateUrl : './flagged.posts.component.html',
    styleUrls   : [
        './flagged.posts.component.css'
    ] 
})

@AutoUnsubscribe
export class FlaggedPostsComponent {
    @Input() user : User;
    constructor(private postService : PostService)
    {

    }
}