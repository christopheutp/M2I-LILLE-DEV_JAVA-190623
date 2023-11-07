import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  @Output() close = new EventEmitter()

  clickHandler(event: Event | undefined = undefined) {
    if (event) {
      if (event.currentTarget === event.target) this.close.emit()
    } else this.close.emit()
  }
}
