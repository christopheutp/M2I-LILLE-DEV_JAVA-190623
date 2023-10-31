import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-communication';

  variableParent = "John"

  changeVariable(text: string) {
    this.variableParent = text
  }
}
