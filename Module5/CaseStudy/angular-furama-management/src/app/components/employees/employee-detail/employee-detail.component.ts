import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Employee} from "../../../models/employee";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  employee: Employee;
  constructor(private employeeService: EmployeeService, private activatedRoute: ActivatedRoute, private router: Router) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.employeeService.findById(id).subscribe(e => {
        this.employee = e;
      });
    });
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.employeeService.delete(id).subscribe();
    this.router.navigateByUrl("/employees");
  }
}
