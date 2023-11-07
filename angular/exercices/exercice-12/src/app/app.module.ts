import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FizzbuzzDisplayComponent } from './components/fizzbuzz-display/fizzbuzz-display.component';
import { FizzbuzzPipe } from './pipes/fizzbuzz.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FizzbuzzDisplayComponent,
    FizzbuzzPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
