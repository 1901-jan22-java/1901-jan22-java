import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';

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

  heroes: Hero[];

  constructor(private heroService: HeroService) { }

  // New version of getHeroes() method
  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(
        heroes => this.heroes = heroes
      );
  }

  // Old version of getHeroes() method
  // getHeroes(): void {
  //   this.heroes = this.heroService.getHeroes();
  // }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.addHero({ name } as Hero)
      .subscribe(hero => {
        this.heroes.push(hero);
      });
  }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService.deleteHero(hero).subscribe();
  }

  ngOnInit() {
    this.getHeroes();
  }

}