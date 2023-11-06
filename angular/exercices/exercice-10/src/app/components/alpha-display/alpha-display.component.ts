import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs'
import { CounterService } from 'src/app/services/counter.service';

@Component({
  selector: 'app-alpha-display',
  templateUrl: './alpha-display.component.html',
  styleUrls: ['./alpha-display.component.css']
})
export class AlphaDisplayComponent implements OnInit, OnDestroy { 
  counterSub: Subscription | undefined
  currentLetter = "a"

  constructor(
    private counterService: CounterService
  ) { }

  ngOnInit(): void {
    this.counterSub = this.counterService.count(25).subscribe({
      next: (number) => {
        this.currentLetter = String.fromCharCode(number + 65)
        console.log("J'ai reçu un nombre ! " + number);
        
      }
    })
  }

  ngOnDestroy(): void {
    if (this.counterSub) this.counterSub.unsubscribe()
  }

  // startCounting() {
  //   this.counterService.count(25).subscribe({
  //     next: (number) => {
  //       this.currentLetter = String.fromCharCode(number + 65)
  //       console.log("J'ai reçu un nombre ! " + number);
        
  //     }
  //   })
  // }

}
