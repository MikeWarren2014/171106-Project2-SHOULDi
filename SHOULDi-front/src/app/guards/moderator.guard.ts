import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { UserRoles } from "../models/userRoles";

@Injectable()
export class ModeratorGuard implements CanActivate
{
    constructor(private router : Router) {}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
    {
        // if user in localStorage is not moderator 
        if (JSON.parse(localStorage.getItem("currentUser")).role !== UserRoles.MODERATOR)
        {
            // redirect them?
            this.router.navigate(['/login'], { queryParams : { returnUrl : state.url }});
            return false;
        }
        return true;
    }
    
}