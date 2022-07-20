import { Component, OnInit } from '@angular/core';
import {FacilityService} from "../../../services/facility.service";
import {Room} from "../../../models/room";
import {Villa} from "../../../models/villa";
import {House} from "../../../models/house";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {Customer} from "../../../models/customer";
import {Employee} from "../../../models/employee";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})

export class FacilityListComponent implements OnInit {
  facilities: (Room | House | Villa)[] = [];
  rooms: Room[] = [];
  villas: Villa[] = [];
  houses: House[] = [];
  p: number = 1;
  formChooseFacilityCreate: FormGroup;

  constructor(private facilityService: FacilityService, private router: Router) { }

  ngOnInit(): void {
    this.facilityService.getHouses().subscribe(t => {
      this.houses = t;
      this.facilities.push(...t);
    });
    this.facilityService.getVillas().subscribe(t => {
      this.villas = t;
      this.facilities.push(...t);
    });
    this.facilityService.getRooms().subscribe(t => {
      this.rooms = t;
      this.facilities.push(...t);
    });
    this.formChooseFacilityCreate = new FormGroup({
      type_facility: new FormControl('')
    });
  }

  create() {
    this.router.navigateByUrl("/facilities/create/" + this.formChooseFacilityCreate.value.type_facility);
  }

  navigateToComponentDetail(index: number) {
    let id = this.facilities[index].id;
    // Villa
    if("area_pool" in this.facilities[index]) {
      this.router.navigateByUrl("/facilities/detail/villa/" + id);
    }
    // Room
    else if("free_services" in this.facilities[index]) {
      this.router.navigateByUrl("/facilities/detail/room/" + id);
    }
    // House
    else {
      this.router.navigateByUrl("/facilities/detail/house/" + id);
    }
  }
}
