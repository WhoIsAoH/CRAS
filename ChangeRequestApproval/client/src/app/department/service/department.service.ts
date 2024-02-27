import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {IDepartment} from "./department";
import any = jasmine.any;

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private apiUrl='http://localhost:8080'

  constructor(private http:HttpClient) { }
  getDepartment():Observable<any>{
    return this.http.get<any[]>(this.apiUrl)
      .pipe(catchError(this.errorHandler))
  }
  errorHandler(error:HttpErrorResponse){
    return throwError(error)
  }
}
