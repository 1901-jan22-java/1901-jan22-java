import { Component, OnInit } from '@angular/core';
import { Placeholder } from '@angular/compiler/src/i18n/i18n_ast';

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
  class = ['primary', 'secondary', 'warning', 'danger', 'light', 'dark'];
  employees = [
    {
      name: 'Genesis1',
      role: 'Trainer'
    },
    {
      name: 'Genesis2',
      role: 'Trainer'
    },
    {
      name: 'Genesis3',
      role: 'Trainer'
    },
    {
      name: 'Genesis4',
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
    this.placeholder++;
    this.buttonClass = `btn btn-${this.class[this.placeholder % 6]}`;
  }

}
