import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { CounterService } from 'src/app/services/fizzbuzz.service';

@Component({
  selector: 'app-fizzbuzz-display',
  templateUrl: './fizzbuzz-display.component.html',
  styleUrls: ['./fizzbuzz-display.component.css']
})
export class FizzbuzzDisplayComponent implements OnDestroy {
  counterValue = 0
  counterSub: Subscription | undefined

  constructor(
    private counterService: CounterService
  ) {
    this.counterSub = this.counterService.counter$.subscribe(value => this.counterValue = value)
  }

  ngOnDestroy(): void {
    this.counterSub?.unsubscribe()
  }

}
