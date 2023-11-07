import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import Dog from '../models/dog.model';

type DogFormMode = "edit" | "add" | "delete" | null

@Injectable({
  providedIn: 'root'
})
class DogService {

  // Informer les composants des chiens actuellement disponibles
  dogs$ = new BehaviorSubject<Dog[]>([])
  
  /*
    dogs$ = new BehaviorSubject<Record<string, Dog>>({})

    this.dogs$.getValue()[uuid]
  */

  // Informer les composants du chien actuellement en cours de manipulation
  selectedDog$ = new BehaviorSubject<Dog | null>(null)

  // Informer les composants du mode actuel du formulaire des chiens
  dogFormMode$ = new BehaviorSubject<DogFormMode>(null)

  constructor() { }

  addDog(newDog: Dog) {
    const currentDogs = this.dogs$.getValue()
    this.dogs$.next([...currentDogs, newDog])
    console.log(this.dogs$.getValue());
    
  }

  getDogById(dogId: string) {
    console.log("DogId: " + dogId);
    

    const foundDog = this.dogs$.getValue().find(d => d.id === dogId) ?? null
    console.log('Found dog:');
    
    console.log(foundDog);
    
    return foundDog
  }

  deleteDogById(dogId: string) {
    const dogToDelete = this.getDogById(dogId)
    if (dogToDelete) {
      this.dogs$.next(this.dogs$.getValue().filter(d => d !== dogToDelete))
    }
  }

  editDog(dogValues: Dog) {
    const dogToEdit = this.getDogById(dogValues.id)
    if (dogToEdit) {
      const editedDog: Dog = {
        ...dogValues,
        id: dogToEdit.id
      }

      this.dogs$.next([...this.dogs$.getValue().filter(d => d.id !== editedDog.id), editedDog])
    }
  }

  switchSelectedDog(dogId: string) {
    this.selectedDog$.next(this.getDogById(dogId))
  }

  switchDogFormMode(dogFormMode: DogFormMode) {
    this.dogFormMode$.next(dogFormMode)
    if (dogFormMode === 'add') this.selectedDog$.next(null)
  }
}

export { DogService, DogFormMode }
