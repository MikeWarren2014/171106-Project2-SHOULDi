import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TokenService } from '../../services/token.service';
import { AlertService } from '../../services/alert.service';
import { AuthenticationService } from '../../services/authentication.service';
import { AutoUnsubscribe } from '../../autoUnsubscribe';

@Component({
    moduleId: module.id,
    selector   : 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

@AutoUnsubscribe
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService
    ){

        if(TokenService.getToken()){
            this.authenticationService.loginToken()
        }
    }

    ngOnInit() {
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    login(){
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            )
    }
}