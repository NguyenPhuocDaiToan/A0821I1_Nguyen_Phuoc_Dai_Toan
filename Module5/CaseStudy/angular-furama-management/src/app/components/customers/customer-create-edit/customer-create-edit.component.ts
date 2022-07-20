import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Customer} from "../../../models/customer";
import {CustomerService} from "../../../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerType} from "../../../models/customer-type";

@Component({
  selector: 'app-customer-create-edit',
  templateUrl: './customer-create-edit.component.html',
  styleUrls: ['./customer-create-edit.component.css']
})
export class CustomerCreateEditComponent implements OnInit {
  form: FormGroup;
  idCustomer: number;
  customerTypes: CustomerType[];

  constructor(private customerService: CustomerService, private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.idCustomer = this.activatedRoute.snapshot.params['id'];

    this.form = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      gender: new FormControl(),
      birthday: new FormControl(),
      identity_card: new FormControl(),
      phone: new FormControl(),
      email: new FormControl(),
      address: new FormControl(),
      customerType: new FormControl(null),
    });
    if(this.idCustomer != undefined) {
      this.customerService.findCustomerById(this.idCustomer).subscribe(c => {
        this.form.patchValue(c);
      });
    }
    this.customerService.getCustomerTypes().subscribe(cts => this.customerTypes = cts);
  }

  compare(c1: Customer, c2: Customer) {
    if(c1 == null || c2 == null) return true;
    return c1.id == c2.id;
  }

  getCustomerType() {
    return this.form.value.customerType;
  }

  save() {
    if (this.form.value.id == undefined) {
      this.customerService.create(this.form.value).subscribe();
    } else this.customerService.update(this.form.value).subscribe();
    this.router.navigateByUrl('/customers');
  }

  checkIdExist(): boolean {
    return this.idCustomer != undefined;
  }
}
