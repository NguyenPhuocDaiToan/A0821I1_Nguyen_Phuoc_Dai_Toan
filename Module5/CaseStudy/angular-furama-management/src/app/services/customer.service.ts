import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Customer} from "../models/customer";
import {CustomerType} from "../models/customer-type";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + "/customers");
  }
  getCustomerTypes(): Observable<CustomerType[]>{
    return this.http.get<CustomerType[]>(API_URL + "/customer_types");
  }
  findCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(API_URL + "/customers/" + id);
  }
  create(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + "/customers", customer);
  }
  update(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(API_URL + "/customers/" + customer.id, customer);
  }
  delete(id: number): Observable<Customer> {
    return this.http.delete<Customer>(API_URL + "/customers/" + id);
  }
}
