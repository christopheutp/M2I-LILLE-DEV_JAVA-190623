import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fizzbuzz'
})
export class FizzbuzzPipe implements PipeTransform {

  transform(value: number): string | number{
    if (value !==0 && value % 15 === 0) return "FizzBuzz"
    else if (value !==0 && value % 5 === 0) return "Buzz"
    else if (value !==0 && value % 3 === 0) return "Fizz"
    else return value
  }

}
