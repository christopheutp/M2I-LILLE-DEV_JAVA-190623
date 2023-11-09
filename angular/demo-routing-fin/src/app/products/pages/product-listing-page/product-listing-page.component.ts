import { Component } from '@angular/core';
import { ProductsDataService } from '../../services/products-data.service';
import Product from '../../models/product.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-listing-page',
  templateUrl: './product-listing-page.component.html',
  styleUrls: ['./product-listing-page.component.css']
})
export class ProductListingPageComponent {
  products: Product[] = []
  productsSub: Subscription | undefined


  constructor(
    private productsDataService: ProductsDataService
  ) {
    this.productsSub = this.productsDataService.products$.subscribe(prods => this.products = prods)
  }
}
