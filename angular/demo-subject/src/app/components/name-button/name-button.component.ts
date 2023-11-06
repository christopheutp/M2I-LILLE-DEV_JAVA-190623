import { Component } from '@angular/core';
import { NameService } from 'src/app/services/name.service';

@Component({
  selector: 'app-name-button',
  templateUrl: './name-button.component.html',
  styleUrls: ['./name-button.component.css']
})
export class NameButtonComponent {

  constructor(
    private nameService: NameService
  ) { }

  addName() {
    this.nameService.addName("Toto")
  }
}
