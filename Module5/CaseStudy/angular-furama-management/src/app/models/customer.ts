import {CustomerType} from "./customer-type";
import {Person} from "./person";

export class Customer extends Person {
  customerType: CustomerType;
}
