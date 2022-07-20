import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomersRoutingModule } from './customer-routing.module';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {HttpClientModule} from "@angular/common/http";
import { CustomerCreateEditComponent } from './customer-create-edit/customer-create-edit.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [CustomerListComponent, CustomerCreateEditComponent],
  imports: [
    CommonModule,
    CustomersRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ]
})
export class CustomersModule { }
