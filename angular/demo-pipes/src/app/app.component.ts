import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-pipes';

  mesPrenoms = [
    "joHn",
    "hèlèNA",
    "ElLIoT",
    "JACKY",
    "TaO",
    "MiChElle"
  ]

  today = new Date()
  howMany = 1

  onClickHandler() {
    this.mesPrenoms = this.mesPrenoms.slice(0, this.mesPrenoms.length - 1)
    // this.mesPrenoms.pop()

    // const copieMesPrenoms = [...this.mesPrenoms]
    
    // console.log('Tableau de base:');
    // console.log(this.mesPrenoms);
    // console.log('Tableau copié:');
    // console.log(copieMesPrenoms);
    
    // this.mesPrenoms.pop()

    // console.log('Tableau de base:');
    // console.log(this.mesPrenoms);
    // console.log('Tableau copié:');
    // console.log(copieMesPrenoms);
    
    
    
  }
}
