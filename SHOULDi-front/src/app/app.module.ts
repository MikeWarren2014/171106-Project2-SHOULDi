import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

import { HomeComponent } from './components/home/home.component';

import { BannerComponent } from './components/dashboard/banner/banner.component';
import { MenuComponent } from './components/dashboard/menu/menu.component';

import { FeedComponent } from './components/feed/feed.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { FavoritesComponent } from './components/favorites/favorites.component';

import { AlertService } from './services/alert.service';
import { AuthenticationService } from './services/authentication.service';
import { AuthGuard } from './guards/auth.guard';

import { PostService } from './services/post.service';
import { UserService } from './services/user.service';
import { MessageService } from './services/message.service';
import { CommentService } from './services/comment.service';

import { appRoutes } from './routing';
import { HttpModule } from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    BannerComponent,
    MenuComponent,
    FeedComponent,
    LeaderboardComponent,
    FavoritesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    AlertService,
    AuthenticationService,
    AuthGuard,
    UserService,
    PostService,
    MessageService,
    CommentService
    // TODO: bring in other providers here
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
