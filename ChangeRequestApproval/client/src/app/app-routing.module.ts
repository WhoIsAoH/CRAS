import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./auth/login/login.component";
import {HomeComponent} from "./home/home.component";
import {ChangeRequestFormComponent} from "./form/change-request-form/change-request-form.component";
import {AddUserFormComponent} from "./admin/add-user-form/add-user-form.component";
import {RequestedFormComponent} from "./user/requested-form/requested-form.component";
import {NavbarComponent} from "./header/navbar/navbar.component";
import {AdminDashboardComponent} from "./admin/admin-dashboard/admin-dashboard.component";
import {ProfileComponent} from "./profile/profile.component";
import {SidebarComponent} from "./admin/sidebar/sidebar.component";
import {ViewRequestListComponent} from "./admin/view-request-list/view-request-list.component";
import {AssignRequestListComponent} from "./admin/assign-request-list/assign-request-list.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'form', component: ChangeRequestFormComponent },
  { path:'', component:LoginComponent},
  { path:'home', component:HomeComponent},
  { path:'profile', component:ProfileComponent},
  { path:'admin-dashboard', component:AdminDashboardComponent,
    children:[
      {
      path:'profile', component:ProfileComponent
      },
      {
        path:'add-user', component:AddUserFormComponent
      },
      {
        path:'view-request-list', component:ViewRequestListComponent
      },
      {
        path:'assign-request-list', component:AssignRequestListComponent
      }
    ],
  },

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
  RequestedFormComponent,
  NavbarComponent,
  AdminDashboardComponent,
  ProfileComponent,
  SidebarComponent,
  ViewRequestListComponent,
]
