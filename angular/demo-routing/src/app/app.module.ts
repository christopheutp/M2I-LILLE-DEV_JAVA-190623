import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BlablaHeaderComponent } from './blabla/components/blabla-header/blabla-header.component';
import { BlablaBodyComponent } from './blabla/components/blabla-body/blabla-body.component';
import { BlablaFooterComponent } from './blabla/components/blabla-footer/blabla-footer.component';
import { BlablaHomePageComponent } from './blabla/pages/blabla-home-page/blabla-home-page.component';
import { TitiHeaderComponent } from './titi/components/titi-header/titi-header.component';
import { TitiBodyComponent } from './titi/components/titi-body/titi-body.component';
import { TitiFooterComponent } from './titi/components/titi-footer/titi-footer.component';
import { TitiHomePageComponent } from './titi/pages/titi-home-page/titi-home-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { Error404PageComponent } from './pages/error-404-page/error-404-page.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    BlablaHeaderComponent,
    BlablaBodyComponent,
    BlablaFooterComponent,
    BlablaHomePageComponent,
    TitiHeaderComponent,
    TitiBodyComponent,
    TitiFooterComponent,
    TitiHomePageComponent,
    HomePageComponent,
    Error404PageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
