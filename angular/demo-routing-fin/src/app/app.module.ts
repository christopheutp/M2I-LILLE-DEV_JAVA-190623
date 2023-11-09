import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListingPageComponent } from './products/pages/product-listing-page/product-listing-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';
import { ProfilePageComponent } from './admin/pages/profile-page/profile-page.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListingPageComponent,
    ProductDetailsPageComponent,
    HomePageComponent,
    NotFoundPageComponent,
    ProfilePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
