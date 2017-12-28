import { Component } from "@angular/core";
import { PostService } from "../../../../services/post.service";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";


@Component({
    selector    : 'flagged-posts',
    templateUrl : './flagged.posts.component.html',
    styleUrls   : [
        './flagged.posts.component.css'
    ] 
})

@AutoUnsubscribe
export class FlaggedPostsComponent {
    constructor(private postService : PostService)
    {

    }
}