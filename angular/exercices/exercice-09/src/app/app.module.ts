import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TimerFormComponent } from './components/timer-form/timer-form.component';
import { TimerDisplayComponent } from './components/timer-display/timer-display.component';
import { SecondsToTextPipe } from './pipes/seconds-to-text.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TimerFormComponent,
    TimerDisplayComponent,
    SecondsToTextPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
