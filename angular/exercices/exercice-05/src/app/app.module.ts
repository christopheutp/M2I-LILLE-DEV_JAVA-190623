import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ContactFormComponent } from './components/contact-form/contact-form.component';
import { FormsModule } from '@angular/forms';
import { ContactCardComponent } from './components/contact-card/contact-card.component';
import { ContactDeleteButtonComponent } from './components/contact-delete-button/contact-delete-button.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactFormComponent,
    ContactCardComponent,
    ContactDeleteButtonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
