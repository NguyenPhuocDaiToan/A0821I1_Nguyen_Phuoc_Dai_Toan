import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeesRoutingModule } from './employees-routing.module';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import {HttpClientModule} from "@angular/common/http";
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FilterPipeModule} from "ngx-filter-pipe";


@NgModule({
  declarations: [EmployeeListComponent, EmployeeCreateComponent, EmployeeEditComponent, EmployeeDetailComponent],
  imports: [
    CommonModule,
    EmployeesRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FilterPipeModule,
    FormsModule
  ]
})
export class EmployeesModule { }
