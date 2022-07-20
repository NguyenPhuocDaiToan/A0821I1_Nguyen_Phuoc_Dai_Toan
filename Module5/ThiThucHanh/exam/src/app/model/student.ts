import {Group} from "./Group";
import {Teacher} from "./Teacher";

export class Student {
  id: number;
  name: string;
  email: string;
  phone: string;
  group: Group;
  topicName: string;
  teacher: Teacher;
}
