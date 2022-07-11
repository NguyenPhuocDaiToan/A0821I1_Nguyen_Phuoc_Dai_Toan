import { Injectable } from '@angular/core';
import {Category} from '../model/category';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable, Subject} from 'rxjs';
import {tap} from 'rxjs/operators';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  private _refreshNeeded = new Subject<void>();

  get refreshNeeded() {
    return this._refreshNeeded;
  }

  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(API_URL + '/categories');
  // .pipe(
  //     tap(() => {
  //       this.refreshNeeded.next();
  //     })
  //   );
  }

  save(category: Category): Observable<Category> {
    return this.http.post<Category>(API_URL + '/categories', category);
  }

  findById(id: number): Observable<Category> {
    return this.http.get<Category>(`${API_URL}/categories/${id}`);
  }

  update(category: Category): Observable<Category> {
    return this.http.put<Category>(`${API_URL}/categories/${category.id}`, category);
  }

  delete(id: number): Observable<Category> {
    return this.http.delete<Category>(`${API_URL}/categories/${id}`);
  }

  generateIdAuto(): number {
    let id: number;
    this.getAll().subscribe(categories => {
      id = parseInt(String(categories[categories.length - 1].id)) + 1;
    });
    return id;
  }
}
