import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import {ProductCreateComponent} from "./product-create/product-create.component";
import {ProductEditComponent} from "./product-edit/product-edit.component";
import {ProductDetailComponent} from "./product-detail/product-detail.component";
import {ProductDeleteComponent} from "./product-delete/product-delete.component";
import {ReactiveFormsModule} from "@angular/forms";
import {ProductListComponent} from "./product-list/product-list.component";


@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    ProductDetailComponent,
    ProductDeleteComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ReactiveFormsModule
  ]
})
export class ProductModule { }
