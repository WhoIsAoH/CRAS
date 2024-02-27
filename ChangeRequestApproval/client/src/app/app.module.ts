import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppRoutingModule, RoutingComponent} from './app-routing.module';
import { AppComponent } from './app.component';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from "@angular/forms";
import { AddDepartmentComponent } from './department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './department/update-department/update-department.component';
import { DepartmentComponent } from './department/department/department.component';


@NgModule({
  declarations: [
    AppComponent,
    RoutingComponent,
    AddDepartmentComponent,
    UpdateDepartmentComponent,
    DepartmentComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatSelectModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
