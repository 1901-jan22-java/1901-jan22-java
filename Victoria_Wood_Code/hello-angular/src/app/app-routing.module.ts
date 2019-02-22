import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ComponentComponent } from './components/homecomponent/component.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DataBindingComponentComponent } from './components/data-binding-component/data-binding-component.component';
import { LoginComponent } from './components/login/login.component';
import { HttpComponent } from './components/http/http.component';

const routes : Routes = [
    // list of route objects
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path : 'home', component: ComponentComponent},
    {path : 'directives', component: DirectivesComponent},
    {path : 'databinding', component: DataBindingComponentComponent},
    {path : 'login', component : LoginComponent},
    {path : 'http', component : HttpComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [ RouterModule]
})
export class AppRoutingModule{}