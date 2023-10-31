import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-grand-child',
  templateUrl: './grand-child.component.html',
  styleUrls: ['./grand-child.component.css']
})
export class GrandChildComponent {
  @Input({
    alias: 'demoGC',
    required: true
  })
  laVariable!: string

  logUpperInput() {
    console.log(this.laVariable.toUpperCase());
  }
}
