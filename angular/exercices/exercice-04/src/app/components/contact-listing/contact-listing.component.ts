import { Component, Input } from '@angular/core';
import Contact from 'src/app/models/Contact.model';

@Component({
  selector: 'app-contact-listing',
  templateUrl: './contact-listing.component.html',
  styleUrls: ['./contact-listing.component.css']
})
export class ContactListingComponent {
  @Input()
  contacts: Contact[] = []
}
