import { Component, NgModule } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
    // do we need module id here?
    templateUrl : './register.component.html',
    selector    : 'register'
    
})

@NgModule({
    imports: [
         FormsModule      
    ]
})

export class RegisterComponent
{
    model   : any = {
        firstName : '',
        lastName  : ''
    };
    loading = false;

    constructor(
        private router : Router,
        private userService : UserService
        // TODO: decide what other members you need here and bring them in
    )
    {}

    // NOTE: may have to scrap this for a POST request to a Java servlet that handles all the logic for us
    register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    console.log('User successfully registered');
                    this.router.navigate(['/login']);
                },
                error => {
                    console.error(error);
                    this.loading = false;
                }
            )
    }
}