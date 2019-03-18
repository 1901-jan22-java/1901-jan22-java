import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot' // {{ 100 | squareroot }}
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any): any {
    return Math.sqrt(value);
  }

}
/*
Popes are a way to write display value transformations 
that you can declare in your HTML
in order to create a pipe, we must create a class that 
implements the PipeTransform interface, and override the
transform() method of that interface 
the Pipe decorator is used for these classes, where we 
give the pipe the name by which we want its functionality
to be accessed in the template
*/