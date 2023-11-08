import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListingPageComponent } from './products/pages/product-listing-page/product-listing-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProductListingPageComponent,
    ProductDetailsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
