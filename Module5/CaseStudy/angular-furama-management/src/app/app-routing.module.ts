import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'employees',
    loadChildren: () => import ('./components/employees/employees.module').then(m => m.EmployeesModule)
  },
  {
    path: 'customers',
    loadChildren: () => import ('./components/customers/customers.module').then(m => m.CustomersModule)
  },
  {
    path: 'facilities',
    loadChildren: () => import ('./components/facility/facility.module').then(m => m.FacilityModule)
  },
];

@NgModule({
  declarations: [
    HomeComponent,
  ],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
