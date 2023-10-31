import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  maVariable = "Texte de test"

  @Input('varA')
  trucBidule = "Valeur par défaut"

  @Output('blabla')
  unEvenement = new EventEmitter<string>()

  doSmthInParent() {
    this.unEvenement.emit()
  }

  inputChanged(event: Event) {
    this.unEvenement.emit((event.target as HTMLInputElement).value)
  }
}
