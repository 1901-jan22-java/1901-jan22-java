import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { HeroesComponent } from './components/heroes/heroes.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { SquareRootPipe } from './pipes/square-root.pipe';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HttpComponent } from './components/http/http.component';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DataBindingComponent,
    HeroesComponent,
    DirectivesComponent,
    SquareRootPipe,
    NavbarComponent,
    RegisterComponent,
    LoginComponent,
    HttpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
