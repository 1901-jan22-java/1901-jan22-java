import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HEROES } from '../mock-heroes';

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

  heroes = HEROES;
  selectedHero: Hero;
  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  constructor() { }

  ngOnInit() {
  }

}
