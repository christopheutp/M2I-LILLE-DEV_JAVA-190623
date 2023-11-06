import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class NameService {

  // names: string[] = []
  $names = new BehaviorSubject<string[]>([])

  constructor() { }

  // addName(newName: string) {
  //   this.names.push(newName)
  //   console.log("Names in service: ");
    
  //   console.log(this.names);
    
  // }

  addName(newName: string) {
    this.$names.next([...this.$names.getValue(), newName])
  }
}
