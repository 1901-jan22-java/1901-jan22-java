import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-data-binding-component',
  templateUrl: './data-binding-component.component.html',
  styleUrls: ['./data-binding-component.component.css']
})
export class DataBindingComponentComponent implements OnInit {

  text: string = 'hello world!';
  bool: boolean = true;
  count: number = 0;
  colors = ['blue','green','magenta','purple'];
  colorProp = '#123456';
  username = 'testuser';
  currentTime;

  constructor() {
    setInterval(
      ()=> {
        this.currentTime = new Date();
      }, 1000);
    
   }

  ngOnInit() {
  }

  increment(){
    this.count++;
    this.colorProp = this.colors[this.count%this.colors.length]
    
  }

}
