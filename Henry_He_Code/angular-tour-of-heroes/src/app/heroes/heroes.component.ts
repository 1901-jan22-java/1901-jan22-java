import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';

@Component({
  // Selector ~ Component's CSS selector
  // (I prefer to remember them as element selectors)
  selector: 'app-heroes',
  // templateUrl: path to component's template / html
  templateUrl: './heroes.component.html',
  // styleUrls : an array interestingly enough 
  // probably because a component could use multiple style sheets...
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  // Seems hero itself can't be shown
  // But we can show its internal fields using dot notation...
  hero: Hero = {
    id: 1,
    name: 'Windstorm'
  };

  constructor() { }

  ngOnInit() {
  }

}
