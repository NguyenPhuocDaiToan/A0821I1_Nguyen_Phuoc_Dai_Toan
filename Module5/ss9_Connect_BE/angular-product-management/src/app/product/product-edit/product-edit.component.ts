import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  editForm: FormGroup;

  constructor(private productService: ProductService, private activatedRoute : ActivatedRoute,  private router : Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = parseInt(paramMap.get('id'));
      this.productService.findById(id).subscribe(product => {
        this.editForm = new FormGroup({
          id: new FormControl(product.id),
          name: new FormControl(product.name),
          price: new FormControl(product.price),
          description: new FormControl(product.description)
        });
      })});
  }

  ngOnInit(): void {
  }

  update() {
    this.productService.update(this.editForm.value).subscribe();
    this.router.navigateByUrl('/product/list');
  }
}
