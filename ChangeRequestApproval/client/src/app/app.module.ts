import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppRoutingModule, RoutingComponent} from './app-routing.module';
import {AppComponent } from './app.component';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from '@angular/material/button';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatListModule} from '@angular/material/list';
import {MatCardModule} from "@angular/material/card";
import {MatTableModule} from '@angular/material/table';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    RoutingComponent
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
    MatListModule,
    MatCardModule,
    MatTableModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
