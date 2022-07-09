import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Route, Router} from '@angular/router';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  editForm: FormGroup;
  category: Category;
  constructor(private categoryService: CategoryService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.category = this.categoryService.findById(id);
    });
  }

  ngOnInit(): void {
    this.editForm = new FormGroup({
        id: new FormControl(this.category.id),
        name: new FormControl(this.category.name)
      }
    );
  }

  save() {
    this.categoryService.save(this.editForm.value);
    this.router.navigateByUrl('/category/list');
  }
}
