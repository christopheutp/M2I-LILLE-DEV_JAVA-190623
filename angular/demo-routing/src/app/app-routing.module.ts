import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router'

import { HomePageComponent } from './pages/home-page/home-page.component';
import { BlablaHomePageComponent } from './blabla/pages/blabla-home-page/blabla-home-page.component';
import { TitiHomePageComponent } from './titi/pages/titi-home-page/titi-home-page.component';
import { Error404PageComponent } from './pages/error-404-page/error-404-page.component';

const mesRoutes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'blabla', component: BlablaHomePageComponent},
  {path: 'titi', component: TitiHomePageComponent},
  {path: '**', component: Error404PageComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(mesRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
