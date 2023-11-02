import { Component, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent {
  @Input()
  sonContenu = ""

  @Output()
  onClick = new EventEmitter()

  onClickHandler() {
    this.onClick.emit()
  }
}
