import { Component, Output, EventEmitter } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  @Output()
  addContact = new EventEmitter<Contact>()

  contact: Contact = {
    firstname: "",
    lastname: "",
    age: 1
  }

  submitFormHandler(event: Event) {
    event.preventDefault()

    this.addContact.emit(this.contact)

    this.contact  = {
      firstname: "",
      lastname: "",
      age: 1
    } 
  }
}
