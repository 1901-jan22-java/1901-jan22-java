import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

    text = "hello world!";
    bool: boolean = true;
    count = 0;
    colorProp = '#123456';
    colors = ['blue', 'green' , 'magenta', '#857194' , '#123456' , 'yellow'];
    currentTime;
    username = 'testuser';




  constructor() {
    setInterval(
      ()=>{
      this.currentTime = new Date();
  }, 1000);

   }

  ngOnInit() {
  }


  increment()
  {
    this.count++;
    this.colorProp = this.colors[this.count % this.colors.length];
    
  }
}
