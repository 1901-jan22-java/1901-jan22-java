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
  class = ['primary', 'secondary', 'warning', 'danger', 'light', 'dark'];
  employees = [
    {
      name: "Bob LobLaw",
      role: "Lawyer"
    },
    {
      name: "Sterling Archer",
      role: "The worlds most dangerous spy"
    },
    {
      name: "Jan Theman",
      role: "Regional Manager"
    },
    {
      name: "Ron Swanson",
      role: "Head of Parks Dept."
    },
    {
      name: "Jerry Seinfeld",
      role: "Comedian"
    },
    {
      name: "Dennis Smith Jr.",
      role: "Baller"
    }
  ]

  constructor() { }

  ngOnInit() {
  }

  toggleIf(){
    this.showIf = !this.showIf;
    this.placeholder++;
    this.buttonClass = `btn btn-${this.class[this.placeholder%6]}`;
  }

}
