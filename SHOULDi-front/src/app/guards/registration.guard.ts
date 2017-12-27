import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";

@Injectable()
export class RegistrationGuard implements CanActivate
{
    constructor(private router : Router) {}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
    {
        // if user is logged in
        if (localStorage.getItem('currentUser'))
        {
            // redirect them to /home , preserving the state of the router
            this.router.navigate(['/home'], { queryParams : { returnUrl : state.url }});
            // return false
            return false;
        }
            
        return true;
    }
    
}