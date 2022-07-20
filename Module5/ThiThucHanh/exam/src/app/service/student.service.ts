import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../model/student";

const URL_API = `${environment.apiUrl}` + "students";


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getAllStudentsWithPage(page: number): Observable<Student[]> {
    return this.http.get<Student[]>(URL_API + "?page=" + page);
  }

  getAllStudentsNotPagination(): Observable<Student[]> {
    return this.http.get<Student[]>(URL_API + "/not-pagination");
  }

  create(student: Student): Observable<Student> {
    return this.http.post<Student>(URL_API, student);
  }

  update(student: Student): Observable<Student> {
    return this.http.put<Student>(URL_API + "/" + student.id, student);
  }

  findById(id: number): Observable<Student> {
    return this.http.get<Student>(URL_API + '/' + id);
  }

  deleteById(id: number): Observable<Student> {
    return this.http.delete<Student>(URL_API + '/' + id);
  }
}
