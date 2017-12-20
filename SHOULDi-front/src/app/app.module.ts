import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

import { AuthenticationService } from './services/authentication.service';
import { AuthGuard } from './guards/auth.guard';

import { appRoutes } from './routing';
import { UserService } from './services/user.service';
import { HttpModule } from '@angular/http';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    AuthenticationService,
    AuthGuard,
    UserService
    // TODO: bring in other providers here
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
