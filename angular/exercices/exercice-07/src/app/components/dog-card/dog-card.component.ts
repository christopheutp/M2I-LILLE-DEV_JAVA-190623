import { Component, Input } from '@angular/core';
import Dog from 'src/app/models/Dog.model';

@Component({
  selector: 'app-dog-card',
  templateUrl: './dog-card.component.html',
  styleUrls: ['./dog-card.component.css']
})
export class DogCardComponent {
  @Input({
    required: true
  })
  dog!: Dog

}
