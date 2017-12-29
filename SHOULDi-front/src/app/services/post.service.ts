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
    // TODO: check endpoints then add 'complete' to TODO comment of checked endpoint

    // Post service methods for users

    getSomeFeed(){ // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + '/api/posts/unseen/all?token=' + TokenService.getToken())
            .map((res : Response) => res.json());
    }

    getSomeFeedByGender(gender : string){ // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + '/api/posts/unseen/gender/' + gender).map((res : Response) => res.json());
    }

    flagPost(post : Post) { // TODO: need to check endpoint
        return this.http.put(this.BASE_URL + '/api/posts/flag', {
            postID : post._id,
            token  : TokenService.getToken()
        });
    }

    like(post : Post) { // TODO: need to check endpoint
        return this.http.put(this.BASE_URL + '/api/posts/like', 
        {
            token  : TokenService.getToken(),
            postID : post._id
        })
    }

    dislike(post : Post) {  // TODO: need to check endpoint
        return this.http.put(this.BASE_URL + '/api/posts/dislike', 
        {
            token  : TokenService.getToken(),
            postID : post._id
        })
    }

    create(post: Post){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/posts/post', 
        {
            image    : post.image,
            occasion : post.occasion,
            token    : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getAllPostsByUser(user : User) // TODO: need to check endpoint
    {
        return this.http.get(this.BASE_URL + '/api/posts/poster/' + user._id).map((res : Response) => res.json());
    }

    getLikesByPost(post : Post){ // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + 'api/posts/get/likes/' + post._id);
    }

    getDislikesByPost(post : Post){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + 'api/posts/get/dislikes', {
            token : TokenService.getToken()
        });
    }

    getLeaderboardPosts() {  // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + '/api/posts/leaderboard').map((res : Response) => res.json());
    }

    // Post service methods for moderators

    getAllFlaggedPosts() {  // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + '/api/posts/flagged').map((res : Response) => res.json());
    }
    
    unflag(post : Post) { // TODO: need to check endpoint
        return this.http.put(this.BASE_URL + '/api/posts/unflag', {
            postID : post._id,
            token  : TokenService.getToken()
        });
    }

    // Post service methods for generic use

    delete(post : Post){ // TODO: need to check endpoint
        return this.http.delete(this.BASE_URL + '/api/posts/' + post._id);
    }
}