import { Component, OnInit } from '@angular/core';
import {Todo} from '../todo';
import {TodoService} from "../todo.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})

export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content: FormControl = new FormControl();

  constructor(private todoService: TodoService) {

  }

  ngOnInit(): void {
    this.getAll();

  }

  getAll() {
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }
  create() {
    const todo: Todo = {
      id: parseInt(String(this.todos[this.todos.length - 1].id)) + 1,
      content: this.content.value
    }

    this.todoService.create(todo).subscribe();
    this.content.setValue('');
    this.getAll();
  }

  delete(id: number) {
    this.todoService.delete(id).subscribe();
    this.getAll();
  }

  edit(todo: Todo) {
    //this.todoService.edit(id).subscribe();
  }
}
