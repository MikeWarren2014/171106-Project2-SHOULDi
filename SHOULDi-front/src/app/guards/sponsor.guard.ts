import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { UserRoles } from "../models/userRoles";

@Injectable()
export class SponsorGuard implements CanActivate
{
    constructor(private router : Router) {}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
    {
        // if user in localStorage is not sponsor
        if (JSON.parse(localStorage.getItem("currentUser")).role !== UserRoles.SPONSOR)
        {
            // redirect them?
            this.router.navigate(['/home'], { queryParams : { returnUrl : state.url }});
            return false;
        }
        return true;
    }
    
}