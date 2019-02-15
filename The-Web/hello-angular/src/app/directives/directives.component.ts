import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1, 5, 6, 9, 192, 1841984];
  employees = [
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Genesis',
      role: 'Trainer'
    },
    {
      name: 'Kevin',
      role: 'Associate'
    }    
  ];

  constructor() { }

  ngOnInit() {
  }

  toggleIf(){
    this.showIf = !this.showIf;
  }
}
