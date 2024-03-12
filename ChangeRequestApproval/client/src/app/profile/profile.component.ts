import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userId!:number;
  user:any;

  constructor(private userService:UserService)
    {

    }

ngOnInit() {
this.getUserEmail();
}
getUserEmail(){
  const email=this.userService.getEmail().email
  this.userService.getUserIdByEmail(email).subscribe((userId:any)=>
    {
      this.userId=userId;
      console.log("User",userId)
      this.userService.getUserById(this.userId).subscribe(
        (data)=>this.user=data
      );
    }
  );
}
}
