import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import {MaterialModule} from "../../module/material/material.module";
import {AddUserFormComponent} from "../../admin/add-user-form/add-user-form.component";
import {AdminDashboardComponent} from "../../admin/admin-dashboard/admin-dashboard.component";
import {ViewRequestListComponent} from "../../admin/view-request-list/view-request-list.component";
import {SidebarComponent} from "../../admin/sidebar/sidebar.component";

@NgModule({
  declarations: [
    AddUserFormComponent,
    AdminDashboardComponent,
    ViewRequestListComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MaterialModule,
  ],
  exports:[
    AddUserFormComponent,
    AdminDashboardComponent,
    ViewRequestListComponent,
    AdminRoutingModule,
    SidebarComponent
  ]
})
export class AdminModule { }
