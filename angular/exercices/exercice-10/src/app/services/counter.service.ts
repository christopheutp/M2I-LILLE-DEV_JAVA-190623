import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterService {

  constructor() { }

  count(maxValue: number = 100) {
    return new Observable<number>((subscriber) => {
      let count = 0

      setInterval(() => {
        if (count > maxValue) {
          subscriber.complete()
        }
        subscriber.next(count++)
      }, 1000)
    })
  }
}
