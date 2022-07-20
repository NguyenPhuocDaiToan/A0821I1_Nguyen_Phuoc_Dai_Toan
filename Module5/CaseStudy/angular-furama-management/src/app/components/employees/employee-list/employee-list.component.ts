import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee.service";
import {Employee} from "../../../models/employee";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  term: any = { name: '' };
  searchText: string;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.employeeService.getAll().subscribe(employees => {
      this.employees = employees;
    });
  }

  search() {
    // Search by typescript
    // this.employeeService.getAll().subscribe(employees => {
    //   this.employees = employees;
    //   this.employees = this.employees.filter(e =>
    //     e.name.toLowerCase().includes(this.searchText.toLowerCase()) ||
    //     e.email.toLowerCase().includes(this.searchText.toLowerCase())
    //   );
    // });

    // Search by json
    this.employeeService.searchByName(this.searchText).subscribe(employees => this.employees = employees);
  }
}
