import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {UserService} from "../../services/user.service";
import {ToastrService} from "ngx-toastr";
import {Route, Router} from "@angular/router";
@Component({
  selector: 'app-add-user-form',
  templateUrl: './add-user-form.component.html',
  styleUrls: ['./add-user-form.component.css']
})
export class AddUserFormComponent implements OnInit {
  userForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,
              private userService:UserService,
              private toastrService:ToastrService,
              private router:Router
              ) { }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      password: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      department: ['', Validators.required],
      location: ['', Validators.required],
      role: ['', Validators.required],
    });
  }
  onSubmit(): void {
    if (this.userForm.valid) {
      const userForm=this.userForm.value
      this.userService.saveUser(userForm).subscribe(
        ()=>
        {
          this.router.navigate(['/admin/'])
          this.toastrService.success("User Created Successfully!!","success")
        },
        error => {
          this.toastrService.error("Error Creating User!!","error")
        }
      )
      console.log(this.userForm.value);
    } else {
      this.userForm.markAllAsTouched();
    }
  }
}


