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
    getAllForPost(post : Post) // TODO: change the endpoints 
    {
        return this.http.get(this.BASE_URL + '/api/post/' + post._id + '/comments').map((res : Response) => res.json());
    }
    getAllFlaggedComments() // TODO: change the endpoints 
    {
        return this.http.get(this.BASE_URL + '/api/comments/flagged').map((res : Response) => res.json());
    }

    // TODO: refactor this
    createComment(post : Post, comment : Comment)
    {
        return this.http.post(this.BASE_URL + '/api/post/' + post._id + '/comments/create', {
            post    : post,
            comment : comment
        }).map((res : Response) => res.json());
    }
    // TODO: ask Caleb,Xavier if this is enough data to send the back end
    updateComment(comment : Comment) // TODO: change the endpoints 
    {
        return this.http.put(this.BASE_URL + '/api/post/comments/update/' + comment._id, {
            comment : comment
        }).map((res : Response) => res.json());
    }
    
    deleteComment(comment : Comment) // TODO: change the endpoints 
    {
        return this.http.delete(this.BASE_URL + '/api/post/comments/delete/' + comment._id);
    }

    flagComment(comment : Comment) // TODO: change the endpoints 
    {
        return this.http.put(this.BASE_URL + '/api/commments/flag', {
            token     : TokenService.getToken(),
            commentID : comment._id 
        })
    }
    
    
}
