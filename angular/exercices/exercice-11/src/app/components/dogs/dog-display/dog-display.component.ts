import { Component, Input, OnInit } from '@angular/core';
import Dog from 'src/app/models/dog.model';
import { DogFormMode, DogService } from 'src/app/services/dog.service';

@Component({
  selector: 'app-dog-display',
  templateUrl: './dog-display.component.html',
  styleUrls: ['./dog-display.component.css']
})
export class DogDisplayComponent implements OnInit {
  @Input() dogId = ""

  dog: Dog | null = null

  constructor(
    private dogService: DogService
  ) { }

  ngOnInit(): void {
    this.dog = this.dogService.getDogById(this.dogId)
  }

  clickHandler(dogFormMode: DogFormMode) {
    this.dogService.switchDogFormMode(dogFormMode)
    this.dogService.switchSelectedDog(this.dogId)
  }
}
