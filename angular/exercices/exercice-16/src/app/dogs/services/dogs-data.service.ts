import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { v4 as uuid } from 'uuid'
import Dog from '../models/dog.model';

@Injectable({
  providedIn: 'root'
})
export class DogsDataService {
  dogs$ = new BehaviorSubject<Dog[]>([
    {
      id: '1',
      name: 'Bernie',
      birthDate: new Date(),
      breed: 'Labrador'
    },
    {
      id: '2',
      name: 'Fido',
      birthDate: new Date(),
      breed: 'Beagle'
    }
  ])
  selectedDog$ = new BehaviorSubject<Dog | null>(null)

  constructor() { }

  getDogById(dogId: string) {
    return this.dogs$.getValue().find(d => d.id === dogId) ?? null
  }

  addDog(dog: Omit<Dog, 'id'>) {
    this.dogs$.next([...this.dogs$.getValue(), {id: uuid(), ...dog}])
  }

  updateDog(dogValues: Dog) {
    const foundDog = this.getDogById(dogValues.id)

    if (foundDog) {
      this.dogs$.next([
        ...this.dogs$.getValue().filter(d => d.id !== dogValues.id),
        dogValues
      ])
    }
  }

  removeDogById(dogId: string) {
    this.dogs$.next(this.dogs$.getValue().filter(d => d.id !== dogId))
  }

  changeSelectedDog(dogId: string) {
    this.selectedDog$.next(this.getDogById(dogId))
  }
}
