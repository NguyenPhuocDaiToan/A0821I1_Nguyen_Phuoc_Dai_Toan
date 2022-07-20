import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {EducationDegree} from "../../../models/education-degree";
import {Position} from "../../../models/position";
import {Department} from "../../../models/department";
import {Employee} from "../../../models/employee";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  editForm: FormGroup;
  education_degrees: EducationDegree[] = [];
  positions: Position[] = [];
  departments: Department[] = [];

  constructor(private employeeService: EmployeeService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.employeeService.findById(id).subscribe(e => {
        this.editForm = new FormGroup({
          id: new FormControl(e.id),
          name: new FormControl(e.name),
          gender: new FormControl(e.gender),
          birthday: new FormControl(e.birthday),
          identity_card: new FormControl(e.identity_card),
          phone: new FormControl(e.phone),
          email: new FormControl(e.email),
          address: new FormControl(e.address),
          salary: new FormControl(e.salary),
          education_degree: new FormControl(e.education_degree),
          department: new FormControl(e.department),
          position: new FormControl(e.position)
        });
      });
    })
  }

  ngOnInit(): void {
    this.employeeService.getPositions().subscribe(positions => this.positions = positions);
    this.employeeService.getDepartments().subscribe(departments => this.departments = departments);
    this.employeeService.getEducationDegrees().subscribe(education_degrees => this.education_degrees = education_degrees);
  }

  compareEmployee(e1: Employee, e2: Employee): boolean {
    return e1.id === e2.id;
  }

  save() {
    console.log(this.editForm.value);
    this.employeeService.update(this.editForm.value).subscribe();
    this.router.navigateByUrl("/employees");
  }
}
