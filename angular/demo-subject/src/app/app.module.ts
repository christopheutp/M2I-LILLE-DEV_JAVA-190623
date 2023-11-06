import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NameButtonComponent } from './components/name-button/name-button.component';
import { NameDisplayComponent } from './components/name-display/name-display.component';

@NgModule({
  declarations: [
    AppComponent,
    NameButtonComponent,
    NameDisplayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
