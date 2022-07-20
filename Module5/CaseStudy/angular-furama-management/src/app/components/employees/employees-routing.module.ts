import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeCreateComponent} from "./employee-create/employee-create.component";
import {EmployeeEditComponent} from "./employee-edit/employee-edit.component";
import {EmployeeDetailComponent} from "./employee-detail/employee-detail.component";


const routes: Routes = [
  {path: '', component: EmployeeListComponent},
  {path: 'create', component: EmployeeCreateComponent},
  {path: 'detail/:id', component: EmployeeDetailComponent},
  {path: 'edit/:id', component: EmployeeEditComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeesRoutingModule { }
