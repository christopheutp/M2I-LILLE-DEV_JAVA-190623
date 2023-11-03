import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import LogService from './services/log.service';
import DataService from './services/data.service';

/*
  Injecter : 
  * Dans un module (tous les elements de ce module ont acces au meme service)
  * Dans un composant (tous les elements enfants de ce composant ainsi que lui même ont acces au meme service)
  * Dans la racine
*/


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    LogService,
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
