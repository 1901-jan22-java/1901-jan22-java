import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { DirectivesComponent } from './components/directives/directives.component';

// DECORATORS
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DataBindingComponent,
    DirectivesComponent
  ],
  /*
  exports: []
  would be classes that need to be acessible to other compoennts of other
  modules. However, we're not making a multi-module application at the moment,
  so we don't need the array.
   */
  imports: [
    /*
    imports array are modules whose classes are needed by classes within this current module
    */
    BrowserModule,
    FormsModule
  ],
  providers: [
    /*
    services (injectable)
    */
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