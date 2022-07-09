import { Component, OnInit } from '@angular/core';
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  category: Category;
  constructor(private categoryService: CategoryService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.category = this.categoryService.findById(id);
    });
  }

  ngOnInit(): void {
  }

  delete() {
    this.categoryService.delete(this.category.id);
    this.router.navigateByUrl('/category/list');
  }
}
