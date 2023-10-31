import { Component, Output, EventEmitter } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  newContact: Contact = {
    firstname: "",
    lastname: "",
    email: "",
    phoneNumber: ""
  }

  @Output('onAddContact')
  addContact = new EventEmitter<Contact>()

  submitFormHandler(event: Event) {
    event.preventDefault()

    this.addContact.emit(this.newContact)

    this.newContact = {
      firstname: "",
      lastname: "",
      email: "",
      phoneNumber: ""
    }
  }
}
