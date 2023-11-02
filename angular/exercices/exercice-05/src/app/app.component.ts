import { Component } from '@angular/core';
import Contact from './models/Contact.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contacts: Contact[] = []
  title = 'exercice-05';

  addContactHandler(contact: Contact) {
    // this.contacts.push(contact)
    this.contacts = [...this.contacts, contact]
  }

  deleteContactHandler(contact: Contact) {
    this.contacts = [...this.contacts.filter(c => c !== contact)]
  }
}
