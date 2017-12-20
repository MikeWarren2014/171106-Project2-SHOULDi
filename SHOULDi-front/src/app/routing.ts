import { Routes } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';

export const appRoutes : Routes = [
    {
        path     : ''
        // component: 
    },
    {
        path     : 'login',
        component: LoginComponent
    },
    {
        path     : 'register',
        component: RegisterComponent
    },
    // for all other directories go back to home
    {
        path      : '**',
        redirectTo: ''
    }
]