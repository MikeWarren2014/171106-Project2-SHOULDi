import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthenticationService {
    constructor (private http: Http) {}

    login(username : String, password: String)
    {
        
        // TODO: implement this
    }

    logout()
    {
        // log user out by removing them from local storage
        localStorage.removeItem('currentUser');
    }
}