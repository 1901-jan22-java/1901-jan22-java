import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { LoginComponent } from './components/login/login.component'
import { RegisterComponent } from './components/register/register.component';
import { HttpComponent } from './components/http/http.component';


const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    { path: 'home', component: HomeComponent},
    { path: 'http', component: HttpComponent},
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent},
    { path: 'directives', component: DirectivesComponent},
    { path: 'databinding', component: DataBindingComponent}
];


@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}