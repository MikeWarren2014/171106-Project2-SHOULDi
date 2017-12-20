import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../models/user';
import 'rxjs/'

@Injectable()
export class UserService 
{
    // what happens next is the client-side version of what happens on the JDBC side
    // TODO: get with Caleb for the endpoints to hit with this service. 

    constructor(private http : Http) {}

    getAll()
    {
        return this.http.get('/users').map((res : Response) => res.json());
    }
    
    getById(_id: string) {
        return this.http.get('/users/' + _id).map((res: Response) => res.json());
    }
 
    create(user: User) {
        return this.http.post('/users/register', user);
    }
 
    update(user: User) {
        return this.http.put('/users/' + user._id, user);
    }
 
    delete(_id: string) {
        return this.http.delete('/users/' + _id);
    }
}
