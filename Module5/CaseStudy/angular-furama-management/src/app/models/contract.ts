import {Customer} from "./customer";
import {Facility} from "./facility";

export class Contract {
  id: number;
  start_date: Date;
  end_date: Date;
  deposit: number;
  total_price: number;
  customer: Customer;
  facility: Facility;
}
