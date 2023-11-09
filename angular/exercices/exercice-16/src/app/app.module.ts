import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DogListPageComponent } from './dogs/pages/dog-list-page/dog-list-page.component';
import { DogFormPageComponent } from './dogs/pages/dog-form-page/dog-form-page.component';
import { SearchDogPipe } from './dogs/pipes/search-dog.pipe';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DogListPageComponent,
    DogFormPageComponent,
    SearchDogPipe,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
