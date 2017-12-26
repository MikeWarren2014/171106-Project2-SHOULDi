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

    // TODO: get the endpoints
    getSomeFeed(){
        return this.http.get(this.BASE_URL + '/api/posts/feed').map((res : Response) => res.json());
    }
    /**
     * get all posts from the logged in user
     * @param poster : the user to pull posts from
     */
    getPostsFromUser(poster : User)
    {
        return this.http.get(this.BASE_URL + '/api/posts/poster=' + poster._id).map((res : Response) => res.json());
    }
    /**
     * Pulls only some posts posted by the end user, up to a max amount specified.
     * 
     * @param startIndex : the first post to pull
     * 
     * This function should, if there is k < amount posts, return only the k of them. 
     */
    getSomePosts(startIndex : number){
        let amount = 5; // change this to mod the amount of posts to pull 
        return this.http.get(this.BASE_URL + '/api/posts/start=' + startIndex + '&amount=' + amount)
            .map((res: Response) => res.json());
    }    
    getAllFlaggedPosts() { 
        return this.http.get(this.BASE_URL + '/api/posts/flagged').map((res : Response) => res.json());
    }
    getTopPosts() { 
        return this.http.get(this.BASE_URL + '/api/posts/ratings=top').map((res : Response) => res.json());
    }    
    create(post: Post){
        return this.http.post(this.BASE_URL + '/api/posts/post', 
        {
            image    : post.image,
            occasion : post.occasion,
            token    : TokenService.getToken()
        });
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
}