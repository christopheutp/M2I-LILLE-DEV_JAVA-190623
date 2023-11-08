import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListingPageComponent } from './products/pages/product-listing-page/product-listing-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';

const routes: Routes = [
  {path: '', redirectTo: '/products', pathMatch: 'full'}, // /
  {path: 'products', component: ProductListingPageComponent}, // /products
  {path: 'products/:productId', component: ProductDetailsPageComponent} // /products/<productId>
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
