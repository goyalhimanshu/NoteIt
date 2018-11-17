import { Component, OnInit } from '@angular/core';
import {FeedbackModel} from "./feedback-model";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  model:FeedbackModel={
    name:'',
    email:'',
    feedback:''
  };
  constructor() { }

  ngOnInit() {
  }

}
