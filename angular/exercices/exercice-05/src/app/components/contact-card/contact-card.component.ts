import { Component, Input, Output, EventEmitter } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-card',
  templateUrl: './contact-card.component.html',
  styleUrls: ['./contact-card.component.css']
})
export class ContactCardComponent {
  @Input({
    required: true
  })
  contact!: Contact

  @Output()
  deleteContact = new EventEmitter<Contact>()

  deleteContactHandler(contact: Contact) {
    this.deleteContact.emit(contact)
  }



}
