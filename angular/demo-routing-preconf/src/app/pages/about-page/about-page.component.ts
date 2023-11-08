import { Component } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-about-page',
  templateUrl: './about-page.component.html',
  styleUrls: ['./about-page.component.css']
})
export class AboutPageComponent {
  constructor(
    private dataService: DataService
  ) {
    console.log("Au lancement de AboutPage, la valeur dans le service est: " + this.dataService.testValeur);
  }
}
