import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./auth/login/login.component";
import {HomeComponent} from "./home/home.component";
import {ChangeRequestFormComponent} from "./form/change-request-form/change-request-form.component";
import {AddUserFormComponent} from "./admin/add-user-form/add-user-form.component";
import {UserServiceComponent} from "./services/user-service/user-service.component";
import {FormServiceComponent} from "./services/form-service/form-service.component";
import {AdminServiceComponent} from "./services/admin-service/admin-service.component";
import {RequestedFormComponent} from "./user/requested-form/requested-form.component";
import {NavbarComponent} from "./header/navbar/navbar.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'form', component: ChangeRequestFormComponent },
  { path:'', component:LoginComponent},
  { path:'home', component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
export const RoutingComponent=[
  LoginComponent,
  HomeComponent,
  ChangeRequestFormComponent,
  AddUserFormComponent,
  UserServiceComponent,
  FormServiceComponent,
  AdminServiceComponent,
  RequestedFormComponent,
  NavbarComponent
]
