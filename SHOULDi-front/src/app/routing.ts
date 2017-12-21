import { Routes } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const appRoutes : Routes = [
    {
        path     : 'home',
        component: HomeComponent
    },
    {
        path     : '',
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