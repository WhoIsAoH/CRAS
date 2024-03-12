import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./auth/login/login.component";
import {HomeComponent} from "./home/home.component";
import {ChangeRequestFormComponent} from "./form/change-request-form/change-request-form.component";
import {RequestedFormComponent} from "./user/requested-form/requested-form.component";
import {NavbarComponent} from "./header/navbar/navbar.component";
import {ProfileComponent} from "./profile/profile.component";

const routes: Routes = [
  { path: 'form', component: ChangeRequestFormComponent },
  { path:'', component:LoginComponent},
  { path:'home', component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
export const RoutingComponent=[
  HomeComponent,
  ChangeRequestFormComponent,
  RequestedFormComponent,
  NavbarComponent,
  ProfileComponent,
]
