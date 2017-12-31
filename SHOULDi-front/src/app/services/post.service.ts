import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Post } from '../models/post';
import 'rxjs/';
import { User } from '../models/user';
import { HttpService } from './http.service';
import { TokenService } from './token.service';
import { Comment } from '../models/comment';

@Injectable()
export class PostService extends HttpService
{
    // TODO: check endpoints then add 'complete' to TODO comment of checked endpoint

    // Post service methods for users

    getSomeFeed(){ // TODO: need to check endpoint - finished
        return this.http.post(this.BASE_URL + '/api/posts/unseen/all', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getSomeFeedByGender(gender : string){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/unseen/gender', {
            token  : TokenService.getToken(),
            gender : gender
        }).map((res : Response) => res.json());
    }

    flagPost(post : Post) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/flag', {
            token  : TokenService.getToken(),
            post_id : post._id
        }).map((res : Response) => res.json());
    }

    like(post : Post, comment : Comment) { // TODO: need to check endpoint - finished
        console.log(post._id);
        console.log(post.comments);
        return this.http.post(this.BASE_URL + '/api/posts/like', 
        {
            token  : TokenService.getToken(),
            post_id : post._id,
            comment : comment.content
        }).map((res : Response) => res.json());
    }

    dislike(post : Post, comment : Comment) {  // TODO: need to check endpoint - finished
    
        return this.http.post(this.BASE_URL + '/api/posts/dislike', 
        {
            token  : TokenService.getToken(),
            post_id : post._id,
            comment : comment.content
        }).map((res : Response) => res.json());
    }

    create(post: Post){ // TODO: need to check endpoint - finished
        return this.http.post(this.BASE_URL + '/api/posts/post', 
        {
            token    : TokenService.getToken(),
            image    : post.image,
            occasion : post.occasion
        }).map((res : Response) => res.json());
    }

    getAllPostsByUser(user : User) // TODO: need to check endpoint
    {
        return this.http.post(this.BASE_URL + '/api/posts/my/posts', {
            token   : TokenService.getToken(),
            user_id  : user._id
        }).map((res : Response) => res.json());
    }

    getLikesByPost(post : Post){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + 'api/posts/get/likes', {
            token   : TokenService.getToken(),
            post_id  : post._id
        }).map((res : Response) => res.json());
    }

    getDislikesByPost(post : Post){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + 'api/posts/get/dislikes', {
            token   : TokenService.getToken(),
            post_id  : post._id
        }).map((res : Response) => res.json());
    }

    getLeaderboardPosts() {  // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/leaderboard', {
            token   : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    // Post service methods for moderators

    getAllFlaggedPosts() {  // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/flagged', {
            token   : TokenService.getToken(),
        }).map((res : Response) => res.json());
    }
    
    unflagPost(post : Post) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/unflag', {
            token  : TokenService.getToken(),
            post_id : post._id
        }).map((res : Response) => res.json());
    }

    // Post service methods for generic use

    deletePost(post : Post){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/delete', {
            token   : TokenService.getToken(),
            post_id  : post._id
        }).map((res : Response) => res.json());
    }
}