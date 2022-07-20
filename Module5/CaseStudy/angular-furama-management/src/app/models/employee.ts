import {Department} from "./department";
import {EducationDegree} from "./education-degree";
import {Position} from "./position";
import {Person} from "./person";

export class Employee extends Person{
  salary: number;
  department: Department;
  position: Position;
  education_degree: EducationDegree;
}
