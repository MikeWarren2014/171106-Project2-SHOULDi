import { Component, NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { User } from '../../models/user';
import { AlertService } from '../../services/alert.service';
import { HostListener } from '@angular/core/src/metadata/directives';
import { UserRoles } from '../../models/userRoles';
import { AutoUnsubscribe } from '../../autoUnsubscribe';

@Component({
    selector    : 'register',
    templateUrl : './register.component.html',
    styleUrls   : ['./register.component.css']
})

@NgModule({
    imports: [
         FormsModule      
    ]
})

@AutoUnsubscribe
export class RegisterComponent
{
    model   : any = {
        firstName : '',
        lastName  : '',
        // assume base user by default
        role      : UserRoles.BASE_USER
    };
    loading = false;
    genders = [
        "female",
        "male",
        "other"
    ];
    isSponsor = false;

    constructor(
        private router : Router,
        private userService : UserService,
        private alertService: AlertService
    )
    {}

    

    // NOTE: may have to scrap this for a POST request to a Java servlet that handles all the logic for us
    register() {
        this.loading = true;
        // if there's any data in any of the sponsor field, the new user is a sponsor.
        this.model.role = (this.isSponsor) ? UserRoles.SPONSOR : UserRoles.BASE_USER;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('User successfully registered', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                }
            )
    }

}