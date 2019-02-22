import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot' // {{100 | squareroot}} name u wanna have in your template
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return Math.sqrt(value);
  }

}
/*
Pipes are a way to write display value transformations that
you can declare in your HTML

In order to create a pipe, we must create a class that implements the PipeTransform
interface, an oberride the transform() method of that interface

the Pipe decorator is used fo rthese classes, where we gibe the pipe the name by which
we want its funcionality to be accessed in the template. 
*/
