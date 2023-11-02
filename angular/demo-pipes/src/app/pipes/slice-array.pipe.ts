import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sliceArray',
  pure: false
})
export class SliceArrayPipe implements PipeTransform {

  transform(value: any[], maxLength = 10): any[] {
    if (value.length > maxLength) {
      return value.slice(0, maxLength)
    } else {
      return value
    }
  }

}
