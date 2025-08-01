const Employee = require('./Employee');

class Supervisor extends Employee {
  constructor() {
    super();
    this.directReports = [];
  }

  stateName() {
    super.stateName();
    if (this.directReports.length > 0) {
      this.directReports.forEach(emp => emp.stateName());
    }
  }

  add(anEmployee) {
    this.directReports.push(anEmployee);
  }
}

module.exports = Supervisor;
