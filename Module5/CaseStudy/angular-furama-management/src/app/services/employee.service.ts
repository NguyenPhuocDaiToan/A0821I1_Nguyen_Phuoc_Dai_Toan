import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Employee} from "../models/employee";
import {environment} from "../../environments/environment";
import {EducationDegree} from "../models/education-degree";
import {Position} from "../models/position";
import {Department} from "../models/department";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + '/employees');
  }

  getEducationDegrees(): Observable<EducationDegree[]> {
    return this.http.get<EducationDegree[]>(API_URL + '/education_degrees');
  }

  getPositions(): Observable<Position[]> {
    return this.http.get<Position[]>(API_URL + '/positions');
  }

  getDepartments(): Observable<Department[]> {
    return this.http.get<Department[]>(API_URL + '/departments');
  }

  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(API_URL + '/employees/' + id);
  }

  create(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(API_URL + '/employees', employee);
  }

  update(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(API_URL + '/employees/' + employee.id, employee);
  }

  delete(id: number): Observable<Employee> {
    return this.http.delete<Employee>(API_URL + '/employees/' + id);
  }

  searchByName(name: string): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + "/employees?name_like=" + name);
  }
}
