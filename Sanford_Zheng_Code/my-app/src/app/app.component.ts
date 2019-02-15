import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'My First Angular App';
}
/*
  - Data bindings are expressions embedded into templates which are evaluated to
  produce dynamic content in the HTML document.
    - this is a useful and vital feature of Angular as it provides a link between
    the HTML and Typescript code.
  - There are many types of data bindings categorized into one way and two way
  binding
*/