import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../models/user';
import 'rxjs/'
import { HttpService } from './http.service';

@Injectable()
export class UserService extends HttpService
{
    // what happens next is the client-side version of what happens on the JDBC side

    getAllFlagged() // TODO: need to check endpoint
    {
        return this.http.get(this.BASE_URL + '/api/users').map((res : Response) => res.json());
    }

    getHighScoreUsers() // TODO: need to check endpoint
    {
        return this.http.get(this.BASE_URL + '/api/users/favorites').map((res : Response) => res.json());
    }

    getFlaggedUsers()
    {
        return this.http.get(this.BASE_URL + '/api/users/flagged').map((res : Response) => res.json());
    }

    getLockedUsers()
    {
        return this.http.get(this.BASE_URL + '/api/users/locked').map((res : Response) => res.json());
    }
    
    getById(_id: string) { // TODO: need to check endpoint
        return this.http.get(this.BASE_URL + '/api/users/' + _id).map((res: Response) => res.json());
    }
 
    create(user: User) { // TODO: need to check endpoint
        return this.http.post(this.BASE_URL + '/api/users/register', user);
    }
 
    update(user: User) { // TODO: need to check endpoint
        return this.http.put(this.BASE_URL + '/api/users/' + user._id, user);
    }
 
    delete(_id: string) { // TODO: need to check endpoint
        return this.http.delete(this.BASE_URL + '/api/users/' + _id);
    }
}