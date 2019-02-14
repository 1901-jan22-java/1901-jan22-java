import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {
  text = "Hello World!";
  bool = true;
  count = 0;
  color = 0x00000;
  colorProp = '#000000';
  currentTime;
  username = "Username";

  constructor() { }

  ngOnInit() {
  }

  increment() {
    this.count++;
    this.changeColor();
  }

  changeColor() {
    this.color = this.color + 0x000010;
    this.colorProp = '#' + this.color;
    return this.colorProp;
  }

  changeColorByName() {
    this.colorProp = this.username;
  }

}
