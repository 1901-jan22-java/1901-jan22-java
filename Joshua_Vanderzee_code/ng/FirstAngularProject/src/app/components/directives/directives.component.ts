import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArr = [16,1,7,651,,35,51,51,5];
  placeholder = 0;
  buttonClass ='btn btn-warning';
  classes = ['primary', 'secondary', 'warning', 'danger', 'light', 'dark'];
  employee = [{
    name: 'Josh',
    role: 'Developer'
  },{
    name: 'Chris',
    role: 'Developer'
  },{
    name: 'Dan',
    role: 'Developer'
  },{
    name: 'Genisis',
    role: 'Trainer'
  },{
    name: 'Steve',
    role: 'Developer'
  }]

  constructor() { }

  ngOnInit() {
  }
  toggleif(){
    this.showIf = !this.showIf;
    this.buttonClass = `btn btn-${this.classes[this.placeholder++ % 6]}`
  } 
}
