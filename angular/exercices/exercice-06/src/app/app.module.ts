import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TrimEndPipe } from './pipes/trim-end.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TrimEndPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
