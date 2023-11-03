import { Component, Input, Output, EventEmitter, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-timer-display',
  templateUrl: './timer-display.component.html',
  styleUrls: ['./timer-display.component.css']
})
export class TimerDisplayComponent implements OnInit, OnDestroy {
  @Input('defaultValue') defaultValue = 0
  currentTime = 0

  @Output() deleteTimer = new EventEmitter()

  interval: number | undefined

  ngOnInit(): void {
    this.currentTime = this.defaultValue
    this.interval = window.setInterval(() => {
      if (this.currentTime > 0) this.currentTime--
    }, 1000)
  }

  ngOnDestroy(): void {
    if (this.interval) {
      clearInterval(this.interval)
    }
  }

  clickHandler() {
    this.deleteTimer.emit()
  }
}
