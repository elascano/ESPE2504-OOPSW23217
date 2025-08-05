class Employee {
  constructor() {
    this.name = "not assigned yet";
    this.title = "not assigned yet";
  }

  stateName() {
    console.log(`${this.title} ${this.name}`);
  }
}

module.exports = Employee;
