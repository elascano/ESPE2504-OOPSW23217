import { Employee } from './Employee.js';

export class Supervisor extends Employee {
  constructor(name = "", title = "") {
    super(name, title);
    this.directReports = [];
  }

  stateName() {
    super.stateName();
    this.directReports.forEach(employee => {
      employee.stateName();
    });
  }

  add(employee) {
    this.directReports.push(employee);
  }
}
