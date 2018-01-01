import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../models/user';
import 'rxjs/'
import { HttpService } from './http.service';
import { TokenService } from './token.service';

@Injectable()
export class UserService extends HttpService
{
    // what happens next is the client-side version of what happens on the JDBC side

    // User service methods for users

    getScoreByUser(){
        return this.http.post(this.BASE_URL + '/api/users/score', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getLikesByUser(user : User){
        return this.http.post(this.BASE_URL + '/api/users/likes', {
            token : TokenService.getToken(),
            userID : user._id
        }).map((res : Response) => res.json());
    }

    getDislikesByUser(user : User){
        return this.http.post(this.BASE_URL + '/api/users/dislikes', {
            token : TokenService.getToken(),
            userID : user._id
        }).map((res : Response) => res.json());
    }

    // User service methods for moderators

    getFlaggedUsers() // TODO: need to check endpoint
    {
        return this.http.post(this.BASE_URL + '/api/users/flagged', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getLockedUsers() // TODO: need to check endpoint
    {
        return this.http.post(this.BASE_URL + '/api/users/locked', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    lockUser(user : any){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users/lock', {
            token : TokenService.getToken(),
            user_id : user.user_id
        }).map((res : Response) => res.json());
    }

    unlockUser(user : any){ // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users/unlock', {
            token : TokenService.getToken(),
            user_id : user.user_id
        }).map((res : Response) => res.json());
    }

    // User service methods for sponsors

    getHighScoreUsers() // TODO: need to check endpoint
    {
        return this.http.post(this.BASE_URL + '/api/users/favorites', {
            token : TokenService.getToken()
        }).map((res : Response) => res.json());
    }

    getBalance(user : User, balance : number){
        return this.http.post(this.BASE_URL + '/api/users/balance', {
            token : TokenService.getToken(),
            balance : balance
        })
    }
 
    // User service methods for generic use

    getUser(user : User) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users', {
            token : TokenService.getToken(),
            userID : user._id
        }).map((res: Response) => res.json());
    }

    create(user: User) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users/register', user);
    }
 
    update(user: User) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users', {
            token : TokenService.getToken(),
            userID : user._id
        });
    }
 
    delete(user : User) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users', {
            token : TokenService.getToken(),
            userID : user._id
        });
    }
}