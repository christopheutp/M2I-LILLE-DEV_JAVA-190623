import { Component, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms'
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';
import { DogsDataService } from '../../services/dogs-data.service';
import Dog from '../../models/dog.model';

@Component({
  selector: 'app-dog-form-page',
  templateUrl: './dog-form-page.component.html',
  styleUrls: ['./dog-form-page.component.css']
})
export class DogFormPageComponent implements OnDestroy {
  isRequired = false
  isReadOnly = false
  buttonText = "Add"

  dog: Dog = {
    id: '',
    name: '',
    breed: '',
    birthDate: new Date()
  }

  formMode: string = 'add'

  paramsSub: Subscription
  queryParamsSub: Subscription

  constructor(
    private activeRoute: ActivatedRoute,
    private dogsDataService: DogsDataService
  ) {
    this.paramsSub = this.activeRoute.paramMap.subscribe((params: ParamMap) => {
      const dogId = params.get('dogId')
      
      
      if (dogId) {
        const foundDog = this.dogsDataService.getDogById(dogId)
        this.dog = foundDog ? {...foundDog} : this.dog
      }
    })

    this.queryParamsSub = this.activeRoute.queryParamMap.subscribe((qParams: ParamMap) => {
      this.formMode = qParams.get('mode') ?? 'add'

      switch (this.formMode) {
        case 'delete':
          this.isReadOnly = true
          this.isRequired = false
          this.buttonText = 'Confirm'
          break;
        case 'edit':
          this.isReadOnly = false
          this.isRequired = true
          this.buttonText = 'Edit'
          break;
        default:
          this.isReadOnly = false
          this.isRequired = true
          this.buttonText = 'Add'
          break;
      }
    })
  }

  ngOnDestroy(): void {
    this.paramsSub.unsubscribe()
    this.queryParamsSub.unsubscribe()
  }

  submitForm(ngForm: NgForm) {
    const { form } = ngForm

    if (form.valid) {
      switch(this.formMode) {
        case 'edit':
          this.dogsDataService.updateDog({...form.value, id: this.dog.id})
          break;
        default:
          this.dogsDataService.addDog(form.value)
          break
      }
    }
    
    
  }
}
