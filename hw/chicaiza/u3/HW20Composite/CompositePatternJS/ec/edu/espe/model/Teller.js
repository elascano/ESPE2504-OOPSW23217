import { Employee } from './Employee.js';

export class Teller extends Employee {
  constructor(name) {
    super(name, "Teller");
  }

  stateName() {
    super.stateName();
  }
}
