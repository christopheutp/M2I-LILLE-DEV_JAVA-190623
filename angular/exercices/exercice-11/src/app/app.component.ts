import { Component, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs'
import { DogFormMode, DogService } from './services/dog.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'exercice-11';

  dogFormMode: DogFormMode = null
  dogFormModeSub: Subscription | undefined

  constructor(
    private dogService: DogService
  ) {
    this.dogFormModeSub = this.dogService.dogFormMode$.subscribe(mode => this.dogFormMode = mode)
  }

  ngOnDestroy(): void {
    this.dogFormModeSub?.unsubscribe()
  }

  clickHandler() {
    this.dogService.switchDogFormMode('add')
  }

  closeModalHandler() {
    this.dogService.switchDogFormMode(null)
  }
}
