import { Pipe, PipeTransform } from '@angular/core';
import { transformAll } from '@angular/compiler/src/render3/r3_ast';

@Pipe({
  name: 'squareroot'//{{100 | squareroot}}
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any): any {
      return Math.sqrt(value);
  }

}
/*Pipes are a way to write and idsplay transformations 
that you can declare in your html in order to create a 
piple we must create a class that impletes th pipe transform interface
and overides the transform() method of that interface

the pipe decorator is used for these classes, whee we
give the pipe the name by which we want its functionallity 
to be accessed in the template
*/