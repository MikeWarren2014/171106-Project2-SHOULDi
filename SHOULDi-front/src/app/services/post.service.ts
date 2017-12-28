import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Post } from '../models/post';
import 'rxjs/';
import { User } from '../models/user';
import { HttpService } from './http.service';
import { TokenService } from './token.service';

@Injectable()
export class PostService extends HttpService
{
    // TODO: clean this up
    getSomeFeed(){
        return this.http.get(this.BASE_URL + '/api/posts/unseen/all?token=' + TokenService.getToken())
        
            .map((res : Response) => res.json());
    }

    getSomeFeedByGender(){
        return this.http.get(this.BASE_URL + '/api/posts/unseen/gender').map((res : Response) => res.json());
    }
    /**
     * get all posts from the logged in user
     * @param poster : the user to pull posts from
     */
    getPostsFromUser(poster : User)
    {
        return this.http.get(this.BASE_URL + '/api/posts/poster/' + poster._id).map((res : Response) => res.json());
    }
    getAllFlaggedPosts() { 
        return this.http.get(this.BASE_URL + '/api/posts/flagged').map((res : Response) => res.json());
    }
    getTopPosts() { 
        return this.http.get(this.BASE_URL + '/api/posts/top').map((res : Response) => res.json());
    }    
    create(post: Post){
        return this.http.post(this.BASE_URL + '/api/posts/post', 
        {
            image    : post.image,
            occasion : post.occasion,
            token    : TokenService.getToken()
        }).map((res : Response) => res.json());
    }
    update(post: Post){
        return this.http.put(this.BASE_URL + '/api/posts/' + post._id, post);
    }
    delete(post : Post){
        return this.http.delete(this.BASE_URL + '/api/posts/' + post._id);
    }
    flag(post : Post) {
        return this.http.put(this.BASE_URL + '/api/posts/flag', {
            postID : post._id,
            token  : TokenService.getToken()
        });
    }
    unflag(post : Post) {
        return this.http.put(this.BASE_URL + '/api/posts/unflag', {
            postID : post._id,
            token  : TokenService.getToken()
        });
    }
    like(post : Post) {
        return this.http.put(this.BASE_URL + '/api/posts/like', 
        {
            token  : TokenService.getToken(),
            postID : post._id
        })
    }
    dislike(post : Post) { 
        return this.http.put(this.BASE_URL + '/api/posts/dislike', 
        {
            token  : TokenService.getToken(),
            postID : post._id
        })

    }
}