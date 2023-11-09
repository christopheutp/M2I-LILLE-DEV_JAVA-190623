import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DogListPageComponent } from './dogs/pages/dog-list-page/dog-list-page.component';
import { DogFormPageComponent } from './dogs/pages/dog-form-page/dog-form-page.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'dogs', component: DogListPageComponent, children: [
    {path: '', component: DogFormPageComponent},
    {path: ':dogId', component: DogFormPageComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
