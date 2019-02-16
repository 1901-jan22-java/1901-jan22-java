import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { HomeComponent } from './components/home/home.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { HttpComponent } from './http/http/http.component';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [
    AppComponent,
    DirectivesComponent,
    HomeComponent,
    DataBindingComponent,
    SquarerootPipe,
    NavbarComponent,
    LoginComponent,
    HttpComponent,
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