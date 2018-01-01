import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";
import { Post } from "../models/post";
import { Comment } from "../models/comment";
import { HttpService } from "./http.service";
import { TokenService } from "./token.service";
import { User } from "../models/user";


@Injectable()
export class CommentService extends HttpService
{

    // TODO: change the endpoints 
    // NOTE: comments should only be visible to the poster!
    
    getAllByPost(post : Post) // TODO: change the endpoints 
    {
        return this.http.post(this.BASE_URL + '/api/comments', {
            token : TokenService.getToken(),
            postID : post._id
        }).map((res : Response) => res.json());
    }

    createComment(post : Post, comment : Comment)
    {
        return this.http.post(this.BASE_URL + '/api/comments/create', {
            token : TokenService.getToken(),
            postID    : post._id,
            comment : comment
        }).map((res : Response) => res.json());
    }
    
    flagComment(comment : any) // TODO: change the endpoints 
    {
        return this.http.post(this.BASE_URL + '/api/commments/flag', {
            token     : TokenService.getToken(),
            comment_id : comment.comment_id 
        }).map((res : Response) => res.json());
    }
    
    // Comment service methods for moderator

    getAllFlaggedComments() // TODO: change the endpoints 
    {
        return this.http.post(this.BASE_URL + '/api/comments/flagged', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getFlaggedCommentsByUser(user : any){
        return this.http.post(this.BASE_URL + '/api/comments/flagged', {
            token : TokenService.getToken(),
            user_id : user.user_id
        }).map((res : Response) => res.json());
    }
    // TODO: refactor this
    
    unflagComment(comment : any){
        return this.http.post(this.BASE_URL + '/api/comments/unflag', {
            token : TokenService.getToken(),
            comment_id : comment.comment_id            
        }).map((res : Response) => res.json());
    }

    deleteComment(comment : any) // TODO: change the endpoints 
    {
        return this.http.post(this.BASE_URL + '/api/comments/delete', {
            token : TokenService.getToken(),
            comment_id : comment.comment_id
        }).map((res : Response) => res.json());
    }    
}
