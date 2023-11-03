import { Component, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-timer-form',
  templateUrl: './timer-form.component.html',
  styleUrls: ['./timer-form.component.css']
})
export class TimerFormComponent {
  @ViewChild('hours') hoursInputRef!: ElementRef<HTMLInputElement>
  @ViewChild('seconds') secondsInputRef!: ElementRef<HTMLInputElement>
  @ViewChild('minutes') minutesInputRef!: ElementRef<HTMLInputElement>

  @Output() addTimer = new EventEmitter<number>()

  submitHandler(event: Event) {
    event.preventDefault()

    const hours = +this.hoursInputRef.nativeElement.value
    const minutes = +this.minutesInputRef.nativeElement.value
    const seconds = +this.secondsInputRef.nativeElement.value

    this.addTimer.emit(seconds + minutes * 60 + hours * 3600)

    this.hoursInputRef.nativeElement.value = "0"
    this.minutesInputRef.nativeElement.value = "0"
    this.secondsInputRef.nativeElement.value = "0"
  }
}
