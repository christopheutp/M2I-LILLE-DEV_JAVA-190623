import { Component, OnDestroy } from '@angular/core';
import Dog from '../../models/dog.model';
import { Subscription } from 'rxjs'
import { DogsDataService } from '../../services/dogs-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dog-list-page',
  templateUrl: './dog-list-page.component.html',
  styleUrls: ['./dog-list-page.component.css']
})
export class DogListPageComponent implements OnDestroy{
  dogs: Dog[] = []
  dogsSub: Subscription
  selectedDog: Dog | null = null
  selecteDogSub: Subscription

  searchInput = ""
  debouncing: number | undefined

  constructor(
    private dogDataService: DogsDataService,
    private router: Router
  ) {
    this.dogsSub = this.dogDataService.dogs$.subscribe(data => this.dogs = data)
    this.selecteDogSub = this.dogDataService.selectedDog$.subscribe(data => this.selectedDog = data)
  }

  ngOnDestroy(): void {
    this.dogsSub.unsubscribe()
    this.selecteDogSub.unsubscribe()
  }

  debounceSearch(value: string) {
    if (this.debouncing) {
      window.clearTimeout(this.debouncing)
      this.debouncing = undefined
    }

    this.debouncing = window.setTimeout(() => {
      this.searchInput = value
    }, 200)
  }

  changeSelectedDog(dogId: string) {
    if (this.selectedDog?.id === dogId) {
      this.dogDataService.changeSelectedDog('')
      this.router.navigate(['/dogs'])
    } else {
      this.dogDataService.changeSelectedDog(dogId)
      this.router.navigate(['/dogs', dogId], {queryParams: {'mode': 'edit'}})
    }
  }
}
