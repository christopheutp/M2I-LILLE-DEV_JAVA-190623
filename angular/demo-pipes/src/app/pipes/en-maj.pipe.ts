import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'enMaj'
})
export class EnMajPipe implements PipeTransform {

  transform(value: string): string {
    return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase()
  }

  // addition(...numbers: number[]) {
  //   let sum = 0
  //   for(const el of numbers) {
  //     sum += el
  //   }
  //   return sum
  // }

  // test() {
  //   this.addition(1, 2, 3,4 , 5,8 , 7, 8, 9, 5)
  // }

}
