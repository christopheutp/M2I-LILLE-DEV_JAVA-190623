import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  constructor(
    private dataService: DataService,
    private router: Router
  ) {
    console.log("Au lancement de HomePage, la valeur dans le service est: " + this.dataService.testValeur);
    
    this.dataService.testValeur = "Nouvelle valeur"
    
    console.log("Après changement dans HomePage, la valeur dans le service est: " + this.dataService.testValeur);
  }

  navigationWithClick() {
    console.log("Je fais mon code...");
    // /route/<une variable issue du code>
    // this.router.navigate(['/about', 24]) pour /about/24
    this.router.navigate(['/about'])
  }
}
