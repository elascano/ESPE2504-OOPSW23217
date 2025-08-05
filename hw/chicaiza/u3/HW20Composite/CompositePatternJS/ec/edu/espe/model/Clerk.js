import { Employee } from './Employee.js';

export class Clerk extends Employee {
  constructor(name) {
    super(name, "Clerk");
  }

  stateName() {
    super.stateName();
  }
}
