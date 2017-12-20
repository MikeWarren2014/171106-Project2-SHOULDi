import { Component } from '@angular/core';

@Component({
    selector   : 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent
{
    username = '';
    password = '';
    constructor(){

    }
    public submitForm(){
        console.log(this.username + " " + this.password);
    }
}