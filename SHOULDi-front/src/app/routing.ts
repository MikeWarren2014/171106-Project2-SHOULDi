import { Routes } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FeedComponent } from './components/feed/feed.component';
import { AuthGuard } from './guards/auth.guard';

export const appRoutes : Routes = [
    {
        path        : '',
        redirectTo  : 'home',
        pathMatch   : 'full'
    },
    {
        path        : 'home',
        component   : HomeComponent,
        // canActivate : [AuthGuard], // ensures only authenticated users can see home screen
        children    : [
            {
                path       : '',
                redirectTo : 'feed',
                pathMatch  : 'full'
            },
            // {
            //     path       : 'leaderboard'
            //     // component  : 
            // },
            {
                path       : 'feed',
                component  : FeedComponent
            }//,
            // {
            //     path       : 'favorites'
            //     // component  : 
            // },
            // {
            //     path       : 'my-posts'
            //     // component  : 
            // },
            // {
            //     path       : 'create-posts'
            //     // component  : 
            // },
            // {
            //     path       : 'edit-posts'
            //     // component  : 
            // }
        ]
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