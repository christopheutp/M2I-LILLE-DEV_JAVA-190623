import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exercice-09';
  timers = [] as number[]

  addTimerHandler(value: number) {
    this.timers = [...this.timers, value]
  }

  deleteTimerHandler(index: number) {
    this.timers = [...this.timers.filter((_, i) => i !== index )]
  }
}
