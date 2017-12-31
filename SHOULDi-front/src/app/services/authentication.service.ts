import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import { HttpService } from './http.service';
import { TokenService } from './token.service';
import { UserRoles } from '../models/userRoles';

@Injectable()
export class AuthenticationService extends HttpService{

    login(email : String, password: String) {
        return this.http.post(this.BASE_URL + '/api/users/login', {
          email : email,
          password : password  
        }).map((response: Response) => {
            let data = response.json();
            if(data && data.token) {
                localStorage.setItem('currentUser', JSON.stringify(data));
                console.log(localStorage.getItem('currentUser'));
            }
            return true;
        });
    }

    loginToken(){
        return this.http.post(this.BASE_URL + '/api/users/login/token', {
            token : TokenService.getToken()
        }).map((res : Response) => {
            let user = res.json();
            if(user && user.token){
                localStorage.setItem('currentUser', JSON.stringify(user));
            }
        });
    }

    logout() {
        // log user out by removing them from local storage
        localStorage.removeItem('currentUser');
    }
}