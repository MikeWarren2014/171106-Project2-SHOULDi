import { Routes } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const appRoutes : Routes = [
    {
        path     : 'home',
        component: HomeComponent,
        children : [
            {
                path       : '',
                redirectTo : 'feed',
                pathMatch  : 'full'
            },
            {
                path       : 'leaderboard'
                // component  : 
            },
            {
                path       : 'feed'
                // component  : 
            },
            {
                path       : 'favorites'
                // component  : 
            },
            {
                path       : 'my-posts'
                // component  : 
            },
            {
                path       : 'create-posts'
                // component  : 
            },
            {
                path       : 'edit-posts'
                // component  : 
            }
        ]
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