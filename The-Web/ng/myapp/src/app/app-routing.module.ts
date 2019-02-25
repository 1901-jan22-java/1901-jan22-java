import { NgModule} from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from './Components/home/home.component';
import { DirectivesComponent } from './Components/directives/directives.component';
import { DataBindingComponent } from './Components/data-binding/data-binding.component';
import { LoginComponent } from './Components/login/login.component';
import { HttpComponent } from './Components/http/http.component';
import { RegisterComponent } from './Components/register/register.component';

const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'directives', component: DirectivesComponent},
    {path: 'databinding', component: DataBindingComponent},
    {path: 'login', component: LoginComponent},
    {path: 'http', component: HttpComponent},
    {path: 'register', component: RegisterComponent}
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}