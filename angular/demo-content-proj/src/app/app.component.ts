import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-content-proj';

  clickAHandler() {
    console.log("Button A clicked!");
  }

  clickBHandler() {
    console.log("Button B clicked!");
  }
}
