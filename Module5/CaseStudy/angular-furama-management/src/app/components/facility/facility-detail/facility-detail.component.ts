import { Component, OnInit } from '@angular/core';
import {FacilityService} from "../../../services/facility.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {House} from "../../../models/house";
import {Villa} from "../../../models/villa";
import {Room} from "../../../models/room";

@Component({
  selector: 'app-facility-detail',
  templateUrl: './facility-detail.component.html',
  styleUrls: ['./facility-detail.component.css']
})
export class FacilityDetailComponent implements OnInit {
  facility: House | Villa | Room | any;
  type: string;
  id: number;
  constructor(private facilityService: FacilityService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p: ParamMap) => {
      this.type = p.get('type').toLowerCase();
      this.id = Number(p.get('id'));

      if(this.type === 'room') {
        this.facilityService.getRoom(this.id).subscribe(t => {
          this.facility = t;
        });
      }
      else if(this.type === 'house') {
        this.facilityService.getHouse(this.id).subscribe(t => this.facility = t);
      }
      else if(this.type === 'villa') {
        this.facilityService.getVilla(this.id).subscribe(t => this.facility = t);
      }
    });
  }

  navigateToEdit() {
    this.router.navigateByUrl("/facilities/edit/" + this.type + "/" + this.id);
  }
}
