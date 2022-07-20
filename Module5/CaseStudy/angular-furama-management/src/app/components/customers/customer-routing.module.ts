import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerCreateEditComponent} from "./customer-create-edit/customer-create-edit.component";


const routes: Routes = [
  {
    path: "", component: CustomerListComponent
  },
  {
    path: "create", component: CustomerCreateEditComponent
  },
  {
    path: "edit/:id", component: CustomerCreateEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { }
