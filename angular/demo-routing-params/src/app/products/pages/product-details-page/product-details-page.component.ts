import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import Product from '../../models/product.model';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-product-details-page',
  templateUrl: './product-details-page.component.html',
  styleUrls: ['./product-details-page.component.css']
})
export class ProductDetailsPageComponent {
  product: Product | null = null

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    // const productId = this.route.snapshot.params['productId']
    // const paramB = this.route.snapshot.params['paramB']
    // const paramC = this.route.snapshot.params['paramC']

    // const { productId, paramB, paramC } = this.route.snapshot.params

    /*
      Récupération des paramètres de routes:
      * Obligatoires
        * .params
        * .paramMap
      * Optionnels
        * .queryParams
        * .queryParamMap
      
      Pour les avoir à l'instant T:
        * this.route.snapshot.<clé>
      Pour les suivre:
        * this.route.<clé>.subscribe()
    */


    const productId = +(this.route.snapshot.paramMap.get('productId') ?? 0)

    this.product = this.productService.getProductById(productId)

    // /products/<id>?varA=<valeur>

    // console.log("varA:", this.route.snapshot.queryParamMap.get('varA'))

    this.route.queryParamMap.subscribe((params: ParamMap) => {
      console.log(params.get('varA'))
    })

    this.router.navigate(['/products', 12], {
      queryParams: {
        'varA': 'titi'
      }
    })
    
  }

}
