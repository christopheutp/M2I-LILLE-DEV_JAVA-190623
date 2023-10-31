import { Component } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {
  firstname = ""
  lastname = ""
  email = ""
  phoneNumber = ""
  age = 0

  contacts: Contact[] = []

  contactFormSubmitHandler(event: Event) {
    event.preventDefault()

    const newContact = new Contact(
      this.firstname,
      this.lastname,
      this.email,
      this.phoneNumber,
      this.age
    )

    this.contacts.push(newContact)

    this.firstname = ""
    this.lastname = ""
    this.email = ""
    this.phoneNumber = ""
    this.age = 0
  }

  deleteContactHandler(contact: Contact) {
    this.contacts = [...this.contacts.filter(c => c !== contact)]
  }
}
