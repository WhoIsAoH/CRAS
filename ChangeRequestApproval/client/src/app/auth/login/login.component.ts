import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {ToastrService} from "ngx-toastr";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  submitted: boolean = false;
  successMessageVisible: boolean = false;
  eye="visibility_off";
  ptype="password";
  visibility:boolean=false
  loginForm!: FormGroup
  constructor(private router: Router,private formBuilder: FormBuilder ,private authService:AuthService, private toastrService:ToastrService) {
    this.loginForm= this.formBuilder.group(
      {
        username:['',Validators.required],
        password:[''],
      });
  }
  ngOnInit(): void {
  }
  login(): void {
    const email=this.loginForm.get('username')?.value;
    const password=this.loginForm.get('password')?.value;
    if (this.loginForm.valid) {
     this.authService.login(email,password).subscribe(
       (response)=>
       {
         this.router.navigate(['/home'])
         this.toastrService.success("Login Successfully!!","success")
       },
       (error)=>{
         this.toastrService.error("Error Login!!","error")
       }
     )
    }
  }
  togglePasswordVisibility(): void {
   if (this.visibility)
   {
     this.eye="visibility_off"
     this.visibility=false
     this.ptype="password"
   }else {
     this.eye="visibility"
     this.ptype="text"
     this.visibility=true
   }
  }
}

