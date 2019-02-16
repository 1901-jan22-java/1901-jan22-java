import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1,5,6,9,192,1841984];
  placeholder = 0;
  buttonClass = 'btn btn-warning';
  class= ['primary', 'secondary', 'warning', 'danger', 'light', 'dark'];
  employees = [
    {
      name: 'Edwin',
      role: 'person'
    },
    {
      name: 'Aggie',
      role: 'awesome'
    },
    {
      name: 'Pil',
      role: 'person'
    },
    {
      name: 'Geoff',
      role: 'person'
    },
    {
      name: 'Gavin',
      role: 'awesome'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

  toggleIf() {
    this.showIf = !this.showIf;
    this.buttonClass = `btn btn-${this.class[this.placeholder%6]}`;
    this.placeholder++;
  }

}
