import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1,5,6,7,125978];
  placeholder = 0;
  buttonClass = 'btn btn-warning';
  class = ['primary', 'secondary', 'warning'];
  employees = [
    {
      name: 'Sanford Zheng',
      role: 'Associate',
    },{
      name: 'Genesis Bonds',
      role: 'Trainer'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
