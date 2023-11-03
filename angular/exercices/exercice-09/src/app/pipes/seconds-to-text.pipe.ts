import { Pipe, PipeTransform } from '@angular/core';
import { min } from 'rxjs';

@Pipe({
  name: 'secondsToText'
})
export class SecondsToTextPipe implements PipeTransform {

  transform(seconds: number): string {
    
    const hoursString = 
    Math.floor(seconds / 3600) // 3784 / 3600 => 1
    .toString() // "1"
    .padStart(2, '0') // "01"

    const minutesString = 
    Math.floor(seconds / 60 - +hoursString * 60) // 3784 /60 - 1 * 3600 => 3
    .toString() // "3"
    .padStart(2, '0')

    const secondsString = 
    Math.floor(seconds - +hoursString * 3600 - +minutesString * 60) // 4
    .toString() // "4"
    .padStart(2, '0') // "04"


    return `${hoursString}:${minutesString}:${secondsString}`
  }

}
