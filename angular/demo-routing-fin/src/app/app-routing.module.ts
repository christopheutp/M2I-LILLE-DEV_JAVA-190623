import { NgModule, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterModule, RouterStateSnapshot, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProductListingPageComponent } from './products/pages/product-listing-page/product-listing-page.component';
import { ProductDetailsPageComponent } from './products/pages/product-details-page/product-details-page.component';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';
import { ProfilePageComponent } from './admin/pages/profile-page/profile-page.component';
import { AuthService } from './services/auth.service';

const monCanActivate: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
  const authService = inject(AuthService)

  const isValid = !!authService.user$.getValue()
  if (!isValid) {
    const router = inject(Router)
    return router.parseUrl('/')
  }

  return true
}

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'products', component: ProductListingPageComponent, children: [
    {path: ':productName', component: ProductDetailsPageComponent}
  ]},
  {path: 'admin', component: ProfilePageComponent, canActivate: [monCanActivate]},
  {path: '**', component: NotFoundPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
