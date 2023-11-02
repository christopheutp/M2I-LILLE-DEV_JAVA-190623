import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OtherComponent } from './components/other/other.component';
import { EnMajPipe } from './pipes/en-maj.pipe';

@NgModule({
  declarations: [
    AppComponent,
    OtherComponent,
    EnMajPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
