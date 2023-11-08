import { Component, OnDestroy } from '@angular/core';
import { ProductService } from 'src/app/products/services/product.service';
import Product from '../../models/product.model';
import { Subscription } from 'rxjs';

let counter = 0

@Component({
  selector: 'app-product-listing-page',
  templateUrl: './product-listing-page.component.html',
  styleUrls: ['./product-listing-page.component.css']
})
export class ProductListingPageComponent implements OnDestroy {

  products: Product[] = []
  productSub: Subscription | undefined

  constructor(
    private productService: ProductService
  ) {
    this.productSub = this.productService.products$.subscribe(products => this.products = products)
  }

  ngOnDestroy(): void {
    this.productSub?.unsubscribe()
  }

  addProduct() {
    console.log('Ajout...');
    
    this.productService.addProduct({
      id: ++counter,
      name: 'Product ' + counter,
      description: 'Description du produit ' + counter,
      price: +(Math.random() * 20).toFixed(2),
      stock: Math.round(Math.random() * 200)
    })

    console.log(this.productService.products$.getValue());
    
  }
}
