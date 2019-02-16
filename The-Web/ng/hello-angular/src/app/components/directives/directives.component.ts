import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1, 5, 6, 9, 192, 1841984];
  placeholder = 0;
  buttonClass = 'btn btn-warning';
  class = ['primary', 'secondary', 'warning', 'danger',
  'light', 'dark'];
  employees = [
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Patrick',
      role: 'Trainer'
    },
    {
      name: 'Peter',
      role: 'Trainer'
    },
    {
      name: 'Carolyn',
      role: 'Trainer'
    },
    {
      name: 'Fred',
      role: 'Trainer'
    },
    {
      name: 'Lei',
      role: 'Associate'
    },
    {
      name: 'Daysi',
      role: 'Associate'
    },
    {
      name: 'Michael',
      role: 'Associate'
    },
    {
      name: 'Jurgen',
      role: 'Associate'
    },
    {
      name: 'Henry',
      role: 'Associate'
    },
    {
      name: 'Kevin',
      role: 'Associate'
    }
  ];


  constructor() { }

  ngOnInit() {
  }

  toggleIf() {
    this.showIf = !this.showIf;
    this.placeholder++;
    this.buttonClass =  `btn btn-${this.class[this.placeholder % 6]}`;
  }

}
