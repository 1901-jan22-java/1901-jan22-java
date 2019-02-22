import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { ComponentComponent } from './components/homecomponent/component.component';
import { DataBindingComponentComponent } from './components/data-binding-component/data-binding-component.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { HttpComponent } from './components/http/http.component';
import { UserService } from './services/user.service';
//DECORATORS - allow you to add metadata to a class
@NgModule({ //indicates that the following class is an angular module
  declarations: [
    /* Declarations array - holds classes that related to a view.
    There can be three types of classes listed here -
    components, directives, and pipes
     */
    AppComponent,
    ComponentComponent,
    DataBindingComponentComponent,
    DirectivesComponent,
    SquarerootPipe,
    NavbarComponent,
    LoginComponent,
    HttpComponent
  ], /* exports: []
  would be classes that need to be accessible to the componenets
  of other modules, However, we're not making a multi-module
  application at the moment, so we don't need the array */
  imports: [
    /* imports array are modules whose classes are needed by classes withing
    this current module  */
    AppRoutingModule,
    FormsModule,
    BrowserModule,
    HttpClientModule
    
  ],
  providers: [
    /* services (@Injectable) */
    UserService
  ], 
  bootstrap: [AppComponent]
  /* Refers to the root componenet- where the bootstrapping process will begin
  it is the root view of the app */
})
export class AppModule { }
/*
Angular provides its own system of organization of code
and funcitonality. This is accomplished by
containers called modules.

A module is a cohesive block of code with a related set of 
capabilities which have a specific application domain
or workflow.

All Angular applications have at least one module, the root module
typically defined in the file app.module.ts
This module ties together all of you componenets,
services, other modules, and imported modules.
It defines where to befin the boostrapping process of
the application (root component, called AppComponenent)

BOOTSTRAPPING
- an essential process in Angular where the application is loaded
- the bootstrap process loads main.ts - the entry point of 
the application
- this process also starts the dependency injection system in Angular 

DEPENDENCY INJECTION
- a concept that predates Angular. DI is a "flavor of"
Inversion of Control(IoC) that is used to simplify dependency
management in software by reducing the amoutn of information
that the componenet needs to know about its dependencies

*/
