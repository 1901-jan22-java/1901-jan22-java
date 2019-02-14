import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  text: string = 'hello world!';
  bool: boolean = true;
  count = 0;

  constructor() { }

  ngOnInit() {
  }

}
