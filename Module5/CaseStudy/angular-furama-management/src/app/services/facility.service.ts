import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {from, Observable, of} from "rxjs";
import {Villa} from "../models/villa";
import {Room} from "../models/room";
import {House} from "../models/house";
import {RentType} from "../models/rent-type";
import {AttachService} from "../models/attach-service";
const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  constructor(private http: HttpClient) { }

  getHouses(): Observable<House[]> {
    return this.http.get<House[]>(API_URL + "/houses");
  }
  getVillas(): Observable<Villa[]> {
    return this.http.get<Villa[]>(API_URL + "/villas");
  }
  getRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(API_URL + "/rooms");
  }
  getRentTypes(): Observable<RentType[]> {
    return this.http.get<RentType[]>(API_URL + "/rent_types");
  }
  getFreeService(): Observable<AttachService[]> {
    return this.http.get<AttachService[]>(API_URL + "/attach_services?price=0");
  }
  getHouse(id: number): Observable<House> {
    return this.http.get<House>(API_URL + "/houses/" + id);
  }
  getVilla(id: number): Observable<Villa> {
    return this.http.get<Villa>(API_URL + "/villas/" + id);
  }
  getRoom(id: number): Observable<Room> {
    return this.http.get<Room>(API_URL + "/rooms/" + id);
  }
  create(facility: House | Room | Villa, type_facility: string): Observable<House | Room | Villa> {
    if(type_facility.toLowerCase() === 'room') {
      return this.http.post<Room>(API_URL + "/rooms", facility);
    }
    else if(type_facility.toLowerCase() === 'house') {
      return this.http.post<House>(API_URL + "/houses", facility);
    }
    else if(type_facility.toLowerCase() === 'villa') {
      return this.http.post<Villa>(API_URL + "/villas", facility);
    }
  }
}
