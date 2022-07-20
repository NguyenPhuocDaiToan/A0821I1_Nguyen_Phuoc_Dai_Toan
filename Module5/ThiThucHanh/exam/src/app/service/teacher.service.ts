import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Teacher} from "../model/Teacher";
import {HttpClient} from "@angular/common/http";

const API_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(API_URL + "teachers");
  }
}
