import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminDashboardComponent} from "../../admin/admin-dashboard/admin-dashboard.component";
import {ProfileComponent} from "../../profile/profile.component";
import {AddUserFormComponent} from "../../admin/add-user-form/add-user-form.component";
import {ViewRequestListComponent} from "../../admin/view-request-list/view-request-list.component";
import {AssignRequestListComponent} from "../../admin/assign-request-list/assign-request-list.component";
const routes: Routes = [
  { path:'admin', component:AdminDashboardComponent,
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
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
