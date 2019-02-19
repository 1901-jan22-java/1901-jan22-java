import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BankLoginComponent } from './components/bank-login/bank-login.component';
import { BankRegisterComponent } from './components/bank-register/bank-register.component';
import { BankComponent } from './components/bank/bank.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { HomeComponent } from './components/home/home.component';
import { HttpComponent } from './components/http/http.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SquareRootPipe } from './pipes/square-root.pipe';
import { UserService } from './services/user.service';

// DECORATORS
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DataBindingComponent,
    DirectivesComponent,
    SquareRootPipe,
    NavbarComponent,
    BankComponent,
    BankLoginComponent,
    BankRegisterComponent,
    HttpComponent
  ],
  /* exports: [] would be classes that need to be acessible to other compoennts of other modules. However, we're not making a multi-module application at the moment, so we don't need the array. */
  imports: [
    /* imports array are modules whose classes are needed by classes within this current module */
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    /* services (injectable) */
    UserService
  ],
  bootstrap: [AppComponent]
  /*
  Refers to the root component - wher ethe bootstrapping process will begin. It is the root 
  view of the app
  */
})
export class AppModule { }
/*

*/