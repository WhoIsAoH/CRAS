import { Component, OnInit } from '@angular/core';
import {NavigationExtras, Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  submitted: boolean = false;
  successMessageVisible: boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  login(): void {
    this.submitted = true;
    if (this.username && this.password) {
      console.log('Username:', this.username);
      console.log('Password:', this.password);
      this.successMessageVisible = true; // Show success message

      // Send success message to home route
      const navigationExtras: NavigationExtras = {
        state: { successMessage: 'Login successful!' }
      };
      this.router.navigate(['/home'], navigationExtras);
    }
  }

}

