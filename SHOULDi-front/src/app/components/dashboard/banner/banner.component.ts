import { Component } from "@angular/core";
import { AuthenticationService } from "../../../services/authentication.service";
import { Router, ActivatedRoute } from '@angular/router';
import { TokenService } from "../../../services/token.service";

@Component({
    selector    : 'banner',
    templateUrl : './banner.component.html',
    styleUrls   : [
        './banner.component.css'
    ]
})

export class BannerComponent
{
    public visible = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ){}

    public toggleVisible() {
        this.visible = !this.visible;
    }

    public logout(){
        if(TokenService.getToken()){
            this.authenticationService.logout();
        }
        this.router.navigateByUrl("/login");
    }
}