import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exercice-08';
  modalVisibility = ""

  changeModalVisilibty(value: string) {
    this.modalVisibility = value
  }
}
