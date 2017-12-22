import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";
import { Post } from "../models/post";
import { Comment } from "../models/comment";


@Injectable()
export class CommentService
{
    constructor(private http : Http)
    {

    }

    // TODO: get the endpoints 
    // NOTE: comments should only be visible to the poster!
    getAllForPost(post : Post)
    {
        return this.http.get('/post/' + post._id + '/comments').map((res : Response) => res.json());
    }
    createComment(post : Post, comment : Comment)
    {
        return this.http.post('/post/' + post._id + '/comments/create', {
            post    : post,
            comment : comment
        });
    }
    // TODO: ask Caleb,Xavier if this is enough data to send the back end
    updateComment(post : Post, comment : Comment)
    {
        return this.http.put('/post/' + post._id + '/comments/update', {
            post    : post,
            comment : comment
        })
    }
    
    deleteComment(post : Post, comment : Comment)
    {
        return this.http.delete('/post/' + post._id + '/comments/delete/' + comment._id);
    }
    
    
}
