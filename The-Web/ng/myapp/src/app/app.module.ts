import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { DataBindingComponent } from './Components/data-binding/data-binding.component';
import { DirectivesComponent } from './Components/directives/directives.component';
import { SquarerootPipe } from './Pipes/squareroot.pipe';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { LoginComponent } from './Components/login/login.component';
import { HttpComponent } from './Components/http/http.component';
import { RegisterComponent } from './Components/register/register.component';
import { UserService } from './services/user.service';


// DECORATORS
@NgModule({// indicates that the following class is an angular module
  declarations: [
    /* Declarations array - holds classes that are
    related to a view. There can be three types of classes
    listed here - components, directives, and pipes
    */
    AppComponent,
    HomeComponent,
    DataBindingComponent,
    DirectivesComponent,
    DirectivesComponent,
    SquarerootPipe,
    NavbarComponent,
    LoginComponent,
    HttpComponent,
    RegisterComponent
  ], /* , exports: []
    would be classes that need to be accessible to the components
    of other modules. However, we're not making a multi-module
    application at the moment, so we dont need the array
  */
  imports: [
    /** imports array are modules whose classes are needed
     * by classes within this current module
    */
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],

  providers: [
      /** services (@Injectable) */
      UserService
  ],
  bootstrap: [AppComponent]
  /** Refers to the root component - where the bootstrapping process
   * will begin. It is the root view of the app
   */
})
export class AppModule { }
/*
Angualr provides its own system of organization of
code and functionality. This is accomplished by
containers called modules.
A module is a cohesive block of code with a related 
set of capabilities which have a specific application
domain or workflow.
All Angular applications have at least one module, the
root module, typically defined in the file app.module.ts
This module ties together all of your components,
services, other modules, and imported modules.
It defines where to begin the bootstrapping process
of the application (root component, called AppComponent)
BOOTSTRAPPING
- an essential process in Angular where the application
is loaded
- the bootstrap process loads main.ts - the entry point
of the application
- this process also starts the dependency injection
system in Angular
DEPENDENCY INJECTION
- a concept that predates Angular. DI is a "flavor of"
Inversion of Control(IoC) that is used to simplify
dependency management in software by reducing the
amount of information that the component needs to know
about its dependencies
*/