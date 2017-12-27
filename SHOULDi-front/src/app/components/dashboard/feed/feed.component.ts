import { Component,OnInit } from "@angular/core";
import { Post } from "../../../models/post";
import { User } from "../../../models/user"

import { PostService } from "../../../services/post.service";
import { UserService } from "../../../services/user.service"

@Component({
    selector   : 'feed',
    templateUrl: './feed.component.html',
    styleUrls  : [
        './feed.component.css'
    ]
})

export class FeedComponent
{
    // a feed has a logged on user
    currentUser: User;
    // since this component will only have one post at a time, it has currentPost, too
    currentPost: Post;
    users: User[] = []; // does a feed have users?
    // a feed has posts
    // TODO: put in dummy data here...
    posts: Post[] = []; 
    constructor(private userService: UserService,
        private postService : PostService)
    {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
    ngOnInit() {
        this.loadPosts();
    }
    deletePost(post : Post)
    {
        this.postService.delete(post);
    }
    private loadPosts() {
        this.postService.getSomeFeed().subscribe(posts => { this.posts = posts; });
    }

}