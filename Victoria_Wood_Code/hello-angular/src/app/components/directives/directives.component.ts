import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [1, 5, 6, 7, 99, 10989273];
  placeholder = 0;
  buttonClass = 'btn btn-primary';
  class = ['primary', 'secondary', 'warning', 'danger','light', 'dark'];
  employees = [
    {
      name: "Victoria",
      role: "Associate"
    },
    {
      name: "Genesis",
      role: "Trainer"
    },
    {
      name: "Ami",
      role: "Associate"
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
