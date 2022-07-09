import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  createForm: FormGroup;
  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.createForm = new FormGroup({
      name: new FormControl()
    });
  }

  save() {
   this.categoryService.save(this.createForm.value);
   this.router.navigateByUrl('/category/list');
  }
}
