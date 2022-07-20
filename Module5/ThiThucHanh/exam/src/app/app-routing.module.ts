import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentListComponent} from "./component/student-list/student-list.component";
import {StudentCreateEditComponent} from "./component/student-create-edit/student-create-edit.component";


const routes: Routes = [
  {
    path: 'students', component: StudentListComponent
  },
  {
    path: 'students/create', component: StudentCreateEditComponent
  },
  {
    path: 'students/edit/:id', component: StudentCreateEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
