import { Routes } from '@angular/router';

import { AuthGuard } from './guards/auth.guard';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

import { FeedComponent } from './components/dashboard/feed/feed.component';
import { LeaderboardComponent } from './components/dashboard/leaderboard/leaderboard.component';
import { FavoritesComponent } from './components/dashboard/favorites/favorites.component';
import { CreatePostsComponent } from './components/dashboard/posts/create/create.posts.component';
import { MyPostsComponent } from './components/dashboard/posts/my/my.posts.component';
import { EditPostsComponent } from './components/dashboard/posts/edit/edit.posts.component';

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
                path       : 'favorites',
                component  : FavoritesComponent
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
                path       : 'edit-posts',
                component  : EditPostsComponent
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
        path     : 'register',
        component: RegisterComponent
    },
    // for all other directories go back to home
    {
        path      : '**',
        redirectTo: ''
    }
]