import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, tap} from "rxjs";
import {Constraints} from "../endpoints/constraints";
import {JwtHelperService} from "@auth0/angular-jwt";
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginUrl=`${Constraints.authUrl}/authenticate`
  private email = new BehaviorSubject<string>('');
  email$: Observable<string> = this.email.asObservable();
  constructor(private http:HttpClient,private jwtHelper:JwtHelperService) {
    this.setEmail('');
  }
  decodeToken(token: string): any {
    return this.jwtHelper.decodeToken(token);
  }
  setEmail(value: string): void {
    this.email.next(value);
  }
  login(email:string,password:string):Observable<any>{
    const credentials={email,password}
    return this.http.post(this.loginUrl,credentials).pipe(
      tap(
        (response:any)=>
        {
          const token=response.token;
          localStorage.setItem('token',token)
        }
      )
    )
  }
}
