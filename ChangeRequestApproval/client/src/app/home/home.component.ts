import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  successMessage: string = '';
  constructor(private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.successMessage = history.state.successMessage || '';
      if (this.successMessage) {
        setTimeout(() => {
          this.successMessage = '';
        }, 1000);
      }
    });
  }
}
