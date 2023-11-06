import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs'

/*
  Les observables sont une sorte de promesse: 

  Une promesse est un objet du Javascript / Typescript qui peut gérer plusieurs états: 
    * pending (en cours)
    * fullfilled (terminée)
    * rejected (echouée)
  
  Un observable est un objet qui va prendre en paramètre une fonction de configuration
  Cette fonction elle prend en paramètre un élément que l'on appelle généralement le subscriber,
  qui peut gérer, via trois méthodes:
  * l'envoi de données
  * l'envoi d'une erreur
  * l'envoi d'une complétion de l'observable

*/

@Injectable({
  providedIn: 'root'
})
export class DemoObservableService {

  constructor() { }


  countdown() {
    return new Observable<number>((subscriber) => {
      let count = 10

      setInterval(() => {
        // if (count % 2 !== 0) {
        //   subscriber.error("Bad number!")
        // }
        if (count === 0) {
          subscriber.complete()
        }
        subscriber.next(--count)
      }, 1000)
    })
  }

  getRound() {
    return this.countdown().pipe(map(data => `Round: ${data}`))
  }

  // listenCountDown() {
  //   const result = this.countdown()
  //   result.subscribe({
  //     next(value) {
  //       console.log(value);
  //     },
  //   })
  // }
}
