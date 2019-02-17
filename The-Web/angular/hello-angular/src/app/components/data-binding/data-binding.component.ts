import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  text = "Hello World";
  bool = true;
  count = 0;
  colorProp = "green";
  username = "mkoerber";

  constructor() { }

  ngOnInit() {
  }

  increment(){
    this.count++;
  }

}
