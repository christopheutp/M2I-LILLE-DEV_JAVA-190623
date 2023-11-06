import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AlphaDisplayComponent } from './components/alpha-display/alpha-display.component';

@NgModule({
  declarations: [
    AppComponent,
    AlphaDisplayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
