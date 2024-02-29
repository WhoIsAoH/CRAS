import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any = {
    username: 'john_doe',
    email: 'john@example.com',
    password: '********',
    department: 'Network',
    role: 'Developer',
    status: 'Accepted'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
