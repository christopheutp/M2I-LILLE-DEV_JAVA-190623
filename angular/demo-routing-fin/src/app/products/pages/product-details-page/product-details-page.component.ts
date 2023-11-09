import { Component, OnDestroy } from '@angular/core';
import Product from '../../models/product.model';
import { ProductsDataService } from '../../services/products-data.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-details-page',
  templateUrl: './product-details-page.component.html',
  styleUrls: ['./product-details-page.component.css']
})
export class ProductDetailsPageComponent implements OnDestroy {
  product!: Product
  productSub: Subscription | undefined


  constructor(
    private productsDataService: ProductsDataService,
    private activeRoute: ActivatedRoute,
    private router: Router
  ) {
    // On récupère les paramètres de route
    this.productSub = this.activeRoute.paramMap.subscribe((params: ParamMap) => {
      // On cherche à récupérer le produit à partir de son nom
      const prodFound = this.productsDataService.getProductByName(params.get('productName') ?? '')

      // Si on a pas trouvé de produit, on redirige vers la page 404
      if (!prodFound) this.router.navigate(['/not-found'])

      // Sinon, on met à jour le produit
      else this.product = prodFound
    })
  }

  ngOnDestroy(): void {
    this.productSub?.unsubscribe()
  }
}
