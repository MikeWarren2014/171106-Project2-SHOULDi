import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Post } from '../models/post';
import 'rxjs/';
import { User } from '../models/user';

@Injectable()
export class PostService{
    // TODO: get the endpoints
    constructor(private http: Http) {}
    getSomeFeed(){
        return this.http.get('/posts/feed').map((res : Response) => res.json());
    }
    /**
     * get all posts from the logged in user
     * @param poster : the user to pull posts from
     */
    getPostsFromUser(poster : User)
    {
        return this.http.get('/posts/poster=' + poster._id).map((res : Response) => res.json());
    }
    /**
     * Pulls only some posts posted by the end user, up to a max amount specified.
     * 
     * @param poster     : the User who posted the posts
     * @param startIndex : the first post to pull
     * 
     * This function should, if there is k < amount posts, return only the k of them. 
     */
    getSomePostsFromUser(poster : User, startIndex : number){
        let amount = 5; // change this to mod the amount of posts to pull 
        return this.http.get('/posts/start=' + startIndex + '&amount=' + amount)
            .map((res: Response) => res.json());
    }    
    getAllFlaggedPosts() { 
        return this.http.get('/posts/type=flagged').map((res : Response) => res.json());
    }
    getTopPosts() { 
        return this.http.get('/posts/ratings=top').map((res : Response) => res.json());
    }    
    create(post: Post){
        return this.http.post('/posts/create', post);
    }
    update(post: Post){
        return this.http.put('/posts/' + post._id, post);
    }
    delete(post : Post){
        return this.http.delete('/posts/' + post._id);
    }
}