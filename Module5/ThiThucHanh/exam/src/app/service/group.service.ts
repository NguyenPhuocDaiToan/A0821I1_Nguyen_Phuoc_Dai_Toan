import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Teacher} from "../model/Teacher";
import {Student} from "../model/student";
import {HttpClient} from "@angular/common/http";
import {Group} from "../model/Group";

const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Group[]> {
    return this.http.get<Group[]>(API_URL + "groups");
  }
}
