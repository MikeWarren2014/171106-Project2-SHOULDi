import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";
import { Post } from "../models/post";
import { Comment } from "../models/comment";
import { HttpService } from "./http.service";
import { TokenService } from "./token.service";


@Injectable()
export class CommentService extends HttpService
{

    // TODO: change the endpoints 
    // NOTE: comments should only be visible to the poster!
    getAllForPost(post : Post)
    {
        return this.http.get(this.BASE_URL + '/api/post/' + post._id + '/comments').map((res : Response) => res.json());
    }
    getAllFlaggedComments()
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
    updateComment(post : Post, comment : Comment)
    {
        return this.http.put(this.BASE_URL + '/api/post/' + post._id + '/comments/update', {
            post    : post,
            comment : comment
        }).map((res : Response) => res.json());
    }
    
    deleteComment(post : Post, comment : Comment)
    {
        return this.http.delete(this.BASE_URL + '/api/post/' + post._id + '/comments/delete/' + comment._id);
    }

    flagComment(comment : Comment)
    {
        return this.http.put(this.BASE_URL + '/api/commments/flag', {
            token     : TokenService.getToken(),
            commentID : comment._id 
        })
    }
    
    
}
