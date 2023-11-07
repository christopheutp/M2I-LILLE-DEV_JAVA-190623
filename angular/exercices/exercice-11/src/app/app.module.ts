import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ModalComponent } from './components/shared/modal/modal.component';
import { DogFormComponent } from './components/dogs/dog-form/dog-form.component';
import { DogDisplayComponent } from './components/dogs/dog-display/dog-display.component';

@NgModule({
  declarations: [
    AppComponent,
    ModalComponent,
    DogFormComponent,
    DogDisplayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
