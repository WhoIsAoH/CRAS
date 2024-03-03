import {Component, OnInit} from '@angular/core';
import {FormService} from "../../services/form.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-change-request-form',
  templateUrl: './change-request-form.component.html',
  styleUrls: ['./change-request-form.component.css']
})
export class ChangeRequestFormComponent implements OnInit {

  constructor(private formService:FormService,
  private form:FormGroup
  ) {

  }
  ngOnInit(): void {}
}
