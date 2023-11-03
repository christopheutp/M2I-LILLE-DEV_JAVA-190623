import { Component } from '@angular/core';
import LogService from 'src/app/services/log.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {

  // private logService: LogService

  // constructor(logService: LogService) {
  //   this.logService = logService
  // }

  constructor(
    private logService: LogService
  ) { }

  clickHandler() {
    this.logService.sayHi()
  }
}
