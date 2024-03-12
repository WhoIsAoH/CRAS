import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import {NavigationExtras, Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';
  submitted: boolean = false;
  successMessageVisible: boolean = false;
  loginForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder) { 
    this.loginForm = this.fb.group({email:['']})

  }

  ngOnInit(): void {
  }

  login(){
    console.log("form is submitted")
  }

  // login(): void {
  //   this.submitted = true;
  //   if (this.username && this.password) {
  //     console.log('Username:', this.username);
  //     console.log('Password:', this.password);
  //     this.successMessageVisible = true; // Show success message

  //     // Send success message to home route
  //     const navigationExtras: NavigationExtras = {
  //       state: { successMessage: 'Login successful!' }
  //     };
  //     this.router.navigate(['/home'], navigationExtras);
  //   }
  // }

}

