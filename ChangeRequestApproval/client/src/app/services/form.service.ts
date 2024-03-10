import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private apiUrl='http://localhost:8080/form'
  constructor(private http:HttpClient) { }
  saveFormData(form:{}):Observable<any>{
    return this.http.post<any>(`${this.apiUrl}`,form );
  }

}
