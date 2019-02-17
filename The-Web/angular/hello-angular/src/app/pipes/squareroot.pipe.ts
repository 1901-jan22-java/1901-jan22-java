import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot' // {{ 100 | squareroot }}
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any): any {
    return Math.sqrt(value);
  }

}
