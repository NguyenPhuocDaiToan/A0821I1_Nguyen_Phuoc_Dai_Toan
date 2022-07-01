import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor() { }
  number1: number;
  number2: number;
  operator: string;
  result: number;

  ngOnInit(): void {
  }

  calculator(): void {
    switch (this.operator) {
      case '+':
        // tslint:disable-next-line:radix
        this.result = Number.parseInt(String(this.number1)) + Number.parseInt(String(this.number2));
        break;
      case '-':
        this.result = this.number1 - this.number2;
        break;
      case 'x':
        this.result = this.number1 * this.number2;
        break;
      case '/':
        this.result = this.number1 / this.number2;
        break;
      default:
        this.result = -1;
    }
  }
}
