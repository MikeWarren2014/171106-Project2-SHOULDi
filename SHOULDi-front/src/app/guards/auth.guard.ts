import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate
{
    constructor(private router : Router) {}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        // if there is a user already logged in, this can activate
        if (localStorage.getItem("currentUser"))
        {
            return true;
        }

        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }}); // TODO: sanity test this 
        return false;
    }
    
}