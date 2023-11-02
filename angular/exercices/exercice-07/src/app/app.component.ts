import { Component } from '@angular/core';
import Dog from './models/Dog.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  dogs = [
    {
      id: 1,
      name: "Bernie",
      breed: "Labrador",
      age: 2
    },
    {
      id: 2,
      name: "Rex",
      breed: "Doberman",
      age: 7
    }
  ] as Dog[]
  sortingType: keyof Dog | "" = ""
  title = 'exercice-07';
}
