import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
private apiUrl='http://localhost:8080/user'

  constructor(private http:HttpClient) { }
  getUserById(id:number){
      return this.http.get(`${this.apiUrl}/${id}` );
  }

}
