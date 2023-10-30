import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-cond-styling';
  maValeur = ""

  getStyle() {
    return {
      'color': this.maValeur === 'Toto' ? 'green' : 
              this.maValeur === 'Titi' ? 'blue' : 
              'black'
    }
  }

  getClasses() {
    return {
      'la-classe': this.maValeur === 'Tutu',
      'autre-classe': this.maValeur === 'Tata'
    }
  }
}
