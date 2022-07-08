import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  product: Product;
  constructor(
    private productService: ProductService,
    private activatedRoute : ActivatedRoute,
    private router: Router
  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      let id = parseInt(paramMap.get("id"));
      this.productService.findById(id).subscribe(p => this.product = p);
    })
  }

  ngOnInit(): void {

  }

  delete() {
    this.productService.delete(this.product.id).subscribe();
    this.router.navigateByUrl('/product/list');
  }
}
