import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Route, Router} from '@angular/router';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  editForm: FormGroup;

  constructor(private categoryService: CategoryService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = parseInt(paramMap.get('id'));
      this.categoryService.findById(id).subscribe(category => {
        this.editForm = new FormGroup({
          id: new FormControl(category.id),
          name: new FormControl(category.name)
        });
      });});
  }

  ngOnInit(): void {

  }

  update() {
    this.categoryService.update(this.editForm.value).subscribe(() => {
      alert('Update category success');
    }, e => {
      console.error('Error' + e);
    });
    this.router.navigateByUrl('/category/list');
  }
}
