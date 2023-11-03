import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-lifecycle';
  firstVisible = false
  monTexte = "Default"
  
  @ViewChild('age') ageElementRef!: ElementRef<HTMLInputElement>

  changeTextValue(input: HTMLInputElement) {
    const textValue = input.value
    console.log(textValue);
    
    this.monTexte = textValue
  }

  

  switchFirstVisibility() {
    this.firstVisible = !this.firstVisible
  }
}
