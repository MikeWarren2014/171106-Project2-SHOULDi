import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import { HttpService } from './http.service';

@Injectable()
export class AuthenticationService extends HttpService{

    login(username : String, password: String) {
        return this.http.post(this.BASE_URL + '/users/authenticate', { username: username, password: password})
            .map((response: Response) => {
                let user = response.json();
                if(user && user.token) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            })
    }

    logout() {
        // log user out by removing them from local storage
        localStorage.removeItem('currentUser');
    }
}