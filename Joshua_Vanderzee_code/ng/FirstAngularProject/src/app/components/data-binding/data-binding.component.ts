import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {
  text: string = 'This is data in the bind item';
  bool: boolean = true;
  count = 0;
  colorProp = '#456123';
  colors = ['blue','green','red','gray','#165216','#165451','#755682']

  currentTime;
  username = 'testuser';

  increment(){
    this.count++;
    this.colorProp = this.colors[this.count % this.colors.length];
  }
  constructor() {
    setInterval(() => {
      this.currentTime = new Date();
    }, 1000);
   }

  ngOnInit() {


  }

}
