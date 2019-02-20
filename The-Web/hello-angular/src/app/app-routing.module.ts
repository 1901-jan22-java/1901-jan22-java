import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { LoginComponent } from './components/login/login.component';
import { HttpComponent } from './http/http/http.component';

const routes: Routes = [
  //list of route objects
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'directives', component: DirectivesComponent },
  { path: 'databinding', component: DataBindingComponent },
  { path: 'login', component: LoginComponent},
  { path: 'http', component: HttpComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }