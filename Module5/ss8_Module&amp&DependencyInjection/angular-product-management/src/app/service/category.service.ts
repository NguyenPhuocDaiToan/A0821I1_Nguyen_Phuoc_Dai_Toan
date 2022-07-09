import { Injectable } from '@angular/core';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [{
    id: 1,
    name: 'IPhone'
  }, {
    id: 2,
    name: 'Samsung',
  }, {
    id: 3,
    name: 'LG',
  }];
  constructor() { }

  getAll() {
    return this.categories;
  }

  save(category: Category) {
    if(category.id === undefined) {
      category.id = this.categories[this.categories.length - 1].id + 1;
      this.categories.push(category);
    }
    else {
      let index = this.categories.findIndex(c => c.id == category.id);
      this.categories[index] = category;
    }
  }

  findById(id: number) {
    return this.categories.find(c => c.id == id);
  }


  delete(id: number) {
    const index = this.categories.findIndex(c => c.id == id);
    this.categories.splice(index, 1);
  }
}
