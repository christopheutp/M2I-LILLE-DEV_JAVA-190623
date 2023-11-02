import { Component, Input, Output, EventEmitter } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-delete-button',
  templateUrl: './contact-delete-button.component.html',
  styleUrls: ['./contact-delete-button.component.css']
})
export class ContactDeleteButtonComponent {
  @Input({
    required: true
  })
  contact!: Contact

  @Output()
  deleteContact = new EventEmitter<Contact>()

  onClickHandler() {
    this.deleteContact.emit(this.contact)
  }
}
