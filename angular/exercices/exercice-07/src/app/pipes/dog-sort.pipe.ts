import { Pipe, PipeTransform } from '@angular/core';
import Dog from '../models/Dog.model';

@Pipe({
  name: 'dogSort'
})
export class DogSortPipe implements PipeTransform {

  transform(value: Dog[], dogAttribute: keyof Dog | ""): Dog[] {
    if (dogAttribute === "") return value
    else return value.sort((a, b) => a[dogAttribute] < b[dogAttribute] ? -1 : 1)
  }

  transformBis(value: Dog[], dogAttribute: string): Dog[] {
    switch(dogAttribute) {
      case "name":
        return value.sort((a, b) => {
          if (a.name > b.name) return 1
          else return -1
        })
      case "age":
        return value.sort((a, b) => a.age - b.age)
      case "breed":
        return value.sort((a, b) => {
          if (a.breed > b.breed) return 1
          else return -1
        })
      default:
        return value
    }
  }
}
