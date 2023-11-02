import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trimEnd'
})
export class TrimEndPipe implements PipeTransform {

  transform(value: string, maxLength = 50): string {
    if (value.length > 50) {
      return value // 'dsdqsdqsdqsdqdq qsdqsd qsd sqdqs dqs  '
      .trimEnd() // 'dsdqsdqsdqsdqdq qsdqsd qsd sqdqs dqs'
      .substring(0, maxLength) // 'dsdqsdqsdqsdqdq '
      .trimEnd() + '...' // 'dsdqsdqsdqsdqdq...'
    } else {
      return value
    }
  }

}
