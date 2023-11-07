import { Component, OnDestroy, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { v4 as uuid } from 'uuid';
import { Subscription } from 'rxjs';
import Dog from 'src/app/models/dog.model';
import { DogFormMode, DogService } from 'src/app/services/dog.service';

@Component({
  selector: 'app-dog-form',
  templateUrl: './dog-form.component.html',
  styleUrls: ['./dog-form.component.css']
})
export class DogFormComponent implements OnDestroy, AfterViewInit{
  @ViewChild('name') nameInputRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild('breed') breedInputRef: ElementRef<HTMLInputElement> | undefined
  @ViewChild('birthDate') birthDateInputRef: ElementRef<HTMLInputElement> | undefined


  selecteDog: Dog | null = null
  selectedDogSub: Subscription | undefined

  dogFormMode: DogFormMode = 'add'
  dogFormModeSub: Subscription | undefined

  constructor(
    private dogService: DogService
  ) {
    this.selectedDogSub = this.dogService.selectedDog$.subscribe(dog => this.selecteDog = dog)
    this.dogFormModeSub = this.dogService.dogFormMode$.subscribe(mode => this.dogFormMode = mode)
  }

  ngOnDestroy(): void {
    this.selectedDogSub?.unsubscribe()
    this.dogFormModeSub?.unsubscribe()
  }

  ngAfterViewInit(): void {
    if (this.selecteDog) {
      if (this.nameInputRef) this.nameInputRef.nativeElement.value = this.selecteDog.name
      if (this.breedInputRef) this.breedInputRef.nativeElement.value = this.selecteDog.breed
      if (this.birthDateInputRef) this.birthDateInputRef.nativeElement.valueAsDate = this.selecteDog.birthDate
    }
  } 

  getRequired() {
    return this.dogFormMode && (this.dogFormMode === 'edit' || this.dogFormMode === 'add')
  }

  getReadOnly() {
    return this.dogFormMode && this.dogFormMode === 'delete'
  }

  getButtonText(){
    switch(this.dogFormMode) {
      case 'delete':
        return "Confirm";
      case 'edit':
        return "Edit";
      default:
        return "Add"
    }
  }

  submitFormHandler(event: Event) {
    event.preventDefault()

    const formValues: Dog = {
      id: this.selecteDog ? this.selecteDog.id : uuid(),
      name: this.nameInputRef?.nativeElement.value ?? "Toto",
      breed: this.breedInputRef?.nativeElement.value ?? "Chihuahua",
      birthDate: this.birthDateInputRef?.nativeElement.valueAsDate ?? new Date()
    }

    console.log(formValues);
    

    switch(this.dogFormMode) {
      case 'edit':
        this.dogService.editDog(formValues)
        break;
      case 'delete':
        this.dogService.deleteDogById(formValues.id)
        break;
      default:
        this.dogService.addDog(formValues)
    }

    this.dogService.switchDogFormMode(null)
  }
}
