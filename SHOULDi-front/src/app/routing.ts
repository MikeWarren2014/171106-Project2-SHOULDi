import { Routes } from '@angular/router';

import { AuthGuard } from './guards/auth.guard';
import { RegistrationGuard } from './guards/registration.guard';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

import { FeedComponent } from './components/dashboard/feed/feed.component';
import { LeaderboardComponent } from './components/dashboard/leaderboard/leaderboard.component';
import { CreatePostsComponent } from './components/dashboard/posts/create/create.posts.component';
import { MyPostsComponent } from './components/dashboard/posts/my/my.posts.component';
import { ScoreComponent } from './components/dashboard/score/score.component';
import { UsersFlaggedComponent } from './components/dashboard/users/flagged/users.flagged.component';

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
            {
                path       : 'leaderboard',
                component  : LeaderboardComponent
            },
            {
                path       : 'feed',
                component  : FeedComponent
            },
            {
                path       : 'score',
                component  : ScoreComponent
            },
            {
                path       : 'my-posts',
                component  : MyPostsComponent
            },
            {
                path       : 'create-posts',
                component  : CreatePostsComponent
            },
            {
                path       : 'users-flagged',
                component  : UsersFlaggedComponent
            },
            // for everything else, we simply go to the default screen
            {
                path       : '**',
                redirectTo : '' 
            }
        ]
    },
    {
        path     : 'login',
        component: LoginComponent
    },
    {
        path        : 'register',
        canActivate : [ RegistrationGuard ],
        component   : RegisterComponent
    },
    // for all other directories go back to home
    {
        path      : '**',
        redirectTo: ''
    }
]