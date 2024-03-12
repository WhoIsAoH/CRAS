import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-change-request-form',
  templateUrl: './change-request-form.component.html',
  styleUrls: ['./change-request-form.component.css']
})
export class ChangeRequestFormComponent implements OnInit {
  constructor(private route:Router) {}
  ngOnInit(): void {
  }
  submit(){
    this.route.navigate(['/user'])
  }
}
