import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule, RoutingComponent} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {MaterialModule} from "./module/material/material.module";
import {AuthModule} from "./routing/auth/auth.module";
import {JwtModule} from "@auth0/angular-jwt";
import {UserModule} from "./routing/user/user.module";
import {ToastrModule} from "ngx-toastr";
import {AssignRequestListComponent} from "./admin/assign-request-list/assign-request-list.component";
import {AdminModule} from "./routing/admin/admin.module";
export function tokenGetter() {
  return localStorage.getItem("token");
}
@NgModule({
  declarations: [
    AppComponent,
    RoutingComponent,
    AssignRequestListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    AuthModule,
    AdminModule,
    UserModule,

    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
      closeButton:true,
    }),
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
      },
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
