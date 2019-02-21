import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareRoot'
})
export class SquareRootPipe implements PipeTransform {

  transform(value: any): any {
    return Math.sqrt(value);
  }

}
