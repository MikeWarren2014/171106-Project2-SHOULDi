import { Component } from "@angular/core";
import { User } from "../../../../models/user";
import { Post } from "../../../../models/post";
import { Comment } from "../../../../models/comment";
import { UserService } from "../../../../services/user.service";
import { PostService } from "../../../../services/post.service";
import { CommentService } from "../../../../services/comment.service";
import { AutoUnsubscribe } from "../../../../autoUnsubscribe";

@Component({
    selector: "usersFlagged",
    templateUrl: "users.flagged.component.html"
})

@AutoUnsubscribe
export class UsersFlaggedComponent{
    data        : any;
    users       : any[];
    posts       : any[][];
    comments    : any[][];

    constructor(private userService : UserService, private postService : PostService, private commentService : CommentService){
    }

    ngOnInit() { // TODO: finish this
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        //Add 'implements OnInit' to the class.
        console.log(this.userService.getFlaggedUsers().subscribe(data => this.data = data));
        for(let user of this.users){
            this.posts[user._id] = new Array<Post>();
            this.comments[user._id] = new Array<Comment>();
        }
    }

    public lockUser(user : User){ // TODO: finish this
        user.isLocked = true;
        console.log(this.userService.update(user).subscribe(data => this.data = data));
    }

    public showPosts(user : User){ // TODO: finish this
        console.log(this.postService.getAllPostsByUser(user).subscribe(data => this.data = data));
    }

    public deletePost(post : Post){ // TODO: finish this
        console.log(this.postService.deletePost(post).subscribe(data => this.data = data));
    }

    public unflagPost(post : Post){ // TODO: finish this
        post.isFlagged = false;
        console.log(this.postService.unflagPost(post).subscribe(data => this.data = data));
    }
    
    public showComments(user : User){ // TODO: finish this
        console.log(this.commentService.getFlaggedCommentsByUser(user).subscribe(data => this.data = data));
    }

    public deleteComment(comment : Comment){ // TODO: finish this
        console.log(this.commentService.deleteComment(comment).subscribe(data => this.data = data));
    }

    public unflagComment(comment : Comment){ // TODO: finish this
        comment.isFlagged = false;
        console.log(this.commentService.unflagComment(comment).subscribe(data => this.data = data));
    }
}