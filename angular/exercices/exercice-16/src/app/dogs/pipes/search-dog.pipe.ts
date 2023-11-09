import { Pipe, PipeTransform } from '@angular/core';
import Dog from '../models/dog.model';

@Pipe({
  name: 'searchDog'
})
export class SearchDogPipe implements PipeTransform {

  transform(value: Dog[], searchInput: string): Dog[] {
    return value.filter(d => d.name.startsWith(searchInput)).sort((a, b) => a.id > b.id ? 1 : -1);
  }

}
