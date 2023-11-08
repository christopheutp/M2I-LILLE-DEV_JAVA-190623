import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import Product from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products$ = new BehaviorSubject<Product[]>([])

  constructor() { }

  addProduct(newProduct: Product) {
    this.products$.next([...this.products$.getValue(), newProduct])
  }

  getProductById(productId: number) {
    return this.products$.getValue().find(p => p.id === productId) ?? null
  }
}
