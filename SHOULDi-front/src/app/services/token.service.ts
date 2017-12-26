import { Injectable } from "@angular/core";

@Injectable()
export class TokenService
{
    private static token = '';
    public static getToken() 
    {
        if (localStorage.getItem('currentUser') !== null)
        {
            TokenService.token = JSON.parse(localStorage.getItem('currentUser')).token;
        }
        return TokenService.token;
    }
}