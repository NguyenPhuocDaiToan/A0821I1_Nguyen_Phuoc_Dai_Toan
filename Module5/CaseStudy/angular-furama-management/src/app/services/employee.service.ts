import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Employee} from "../models/employee";
import {environment} from "../../environments/environment";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employees: Employee[] =  [
    {
      id: 1,
      name: "Nguyễn Phước Đại Toàn",
      birthday: new Date(2022, 9, 17),
      identity_card: "123456789",
      phone: "0901234567",
      email: "daitoan2000@gmail.com",
      salary: 2000,
      department: {
        id: 1,
        name: "Sale - Marketing"
      },
      position: {
        "id": 1,
        "name": "Lễ tân"
      },
      education_degree: {
        "id": 1,
        "name": "Trung cấp"
      }
    }
  ]
  constructor(private http: HttpClient) { }
  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/employees');
    //return this.employees;
  }
}
