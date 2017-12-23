import { Component,OnInit } from "@angular/core";
import { Post } from "../../models/post";
import { User } from "../../models/user"

import { PostService } from "../../services/post.service";
import { UserService } from "../../services/user.service"

@Component({
    selector: 'feed',
    templateUrl: './feed.component.html'
})

export class FeedComponent
{
    // a feed has a logged on user
    currentUser: User;
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

    }
    deletePost(post : Post)
    {
        this.postService.delete(post);
    }
    private loadPosts() {
        // this.userService.getAll().subscribe( users => { this.users = users; });
        // this will only get the posts from the end user...
        this.postService.getPostsFromUser(this.currentUser).subscribe(posts => { this.posts = posts; });
    }
}