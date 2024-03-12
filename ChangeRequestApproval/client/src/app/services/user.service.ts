import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Constraints} from "../endpoints/constraints";
import {JwtHelperService} from "@auth0/angular-jwt";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit {
  constructor(private http: HttpClient, private jwtHelper: JwtHelperService, private router: Router) {
    const token = localStorage.getItem('token')
  }

  ngOnInit() {
    this.getEmail()
  }

  getEmail(): { email: string } {
    const token = localStorage.getItem('token');
    if (token) {
      const decodedToken = this.jwtHelper.decodeToken(token);
      const email = decodedToken['sub'];
      console.log(email);
      return {email};
    } else {
      return {email: ''};
    }
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(Constraints.getUserUrl(id));
  }

  saveUser(formData: FormData): Observable<any> {
    return this.http.post(Constraints.saveUserUrl, formData);
  }
}

