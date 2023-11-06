import { Component } from '@angular/core';
import { DemoObservableService } from 'src/app/services/demo-observable.service';
import LogService from 'src/app/services/log.service';
import { map } from 'rxjs'

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {
  affichage = ""

  // private logService: LogService

  // constructor(logService: LogService) {
  //   this.logService = logService
  // }

  constructor(
    private logService: LogService,
    private demoObs: DemoObservableService
  ) { }

  clickHandler() {
    this.logService.sayHi()
    this.demoObs.getRound()
    .subscribe({
      next: (value) => {
        console.log(value);
        this.affichage = value
      },
      error(err) {
        console.error("On a eu une erreur!");
        console.log(err);
      },
      complete() {
        console.log("On a fini");
      },
    })
  }
}
