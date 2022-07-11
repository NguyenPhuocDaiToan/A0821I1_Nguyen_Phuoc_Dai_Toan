import {Department} from "./department";
import {EducationDegree} from "./education-degree";
import {Position} from "./position";

export class Employee {
  id: number;
  name: string;
  birthday: Date;
  identity_card: string;
  phone: string;
  email: string;
  salary: number;
  department: Department;
  position: Position;
  education_degree: EducationDegree;
}
