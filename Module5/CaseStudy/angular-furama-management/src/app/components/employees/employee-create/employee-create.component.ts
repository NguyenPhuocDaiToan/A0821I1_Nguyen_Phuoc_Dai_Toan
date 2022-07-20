import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {EducationDegree} from "../../../models/education-degree";
import {Position} from "../../../models/position";
import {Department} from "../../../models/department";
import {Route, Router} from "@angular/router";
import {Employee} from "../../../models/employee";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  createForm: FormGroup;
  education_degrees: EducationDegree[];
  positions: Position[];
  departments: Department[];

  constructor(private employeeService: EmployeeService, private router: Router) {
  }

  ngOnInit(): void {
    this.createForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(),
      gender: new FormControl(),
      birthday: new FormControl(),
      identity_card: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      address: new FormControl(),
      salary: new FormControl(),
      education_degree: new FormControl(null),
      department: new FormControl(null),
      position: new FormControl(null)
    });

    this.employeeService.getPositions().subscribe(positions => this.positions = positions);
    this.employeeService.getDepartments().subscribe(departments => this.departments = departments);
    this.employeeService.getEducationDegrees().subscribe(education_degrees => this.education_degrees = education_degrees);
  }

  save() {
    this.employeeService.create(this.createForm.value).subscribe();
    this.router.navigateByUrl("/employees");
  }
}
