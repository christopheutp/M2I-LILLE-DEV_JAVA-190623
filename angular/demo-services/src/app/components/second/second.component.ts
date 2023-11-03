import { Component } from '@angular/core';
import LogService from 'src/app/services/log.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent {

  constructor(
    private logService: LogService
  ) { }

  clickHandler() {
    this.logService.sayHi()
  }

}
