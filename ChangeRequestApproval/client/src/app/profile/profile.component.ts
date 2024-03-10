import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any;
  id: number=1;
  constructor(private userService:UserService)
    {}
ngOnInit() {
    this.userService.getUserById(this.id).subscribe(
      (data:any|undefined)=>this.user=data
    )
}
}
