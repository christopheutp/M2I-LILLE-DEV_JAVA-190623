import { Component } from '@angular/core';
import { CounterService } from './services/fizzbuzz.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exercice-12';
  minusButtonDisabled = false

  counterSub: Subscription | undefined

  constructor(
    private counterService: CounterService
  ) {
    this.counterSub = this.counterService.counter$.subscribe(value => this.minusButtonDisabled = value <= 0)
  }

  modifyCounter(nbr: number) {
    this.counterService.changeCounter(nbr)
  }
}
