import { Component } from '@angular/core';

@Component({
  selector: 'app-conditional',
  templateUrl: './conditional.component.html',
  styleUrls: ['./conditional.component.css']
})
export class ConditionalComponent {
  firstname = ""
  estVrai = true
  age = 11
  mesPrenoms = ["John", "Héléna", "Mikael", "Tao"]

  incrementAge() {
    this.age += 1
    this.mesPrenoms.push("Nouveau " + this.age)
  }

  firstnameInputHandler(event: Event) {
    this.firstname = (event.target as HTMLInputElement).value
  }
}
