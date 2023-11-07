import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterService {
  counter$ = new BehaviorSubject(0)

  constructor() { }

  changeCounter(nbr: number) {
    this.counter$.next(this.counter$.getValue() + nbr)
  }
}
