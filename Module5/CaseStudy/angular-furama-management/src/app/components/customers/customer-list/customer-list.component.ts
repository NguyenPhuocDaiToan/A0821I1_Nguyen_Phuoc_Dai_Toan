import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../models/customer";
import {CustomerService} from "../../../services/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  customerTemp: Customer =  {
    id: 0,
    name: "",
    birthday: new Date(),
    identity_card: "",
    gender: true,
    phone: "", email: "",
    address: "",
    customerType: {
      id: 4,
      name: "Silver"
    }
  };

  constructor(private customerService: CustomerService) {

  }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe(customers => this.customers = customers);
  }


  setCustomerById(id: number) {
    this.customerService.findCustomerById(id).subscribe(c => this.customerTemp = c);
  }

  delete(id: number) {
    this.customerService.delete(id).subscribe( () => {
      this.customerService.getCustomers().subscribe(customers => this.customers = customers);
    });
  }
}
