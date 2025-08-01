export class Employee {
  constructor(name = "not assigned yet", title = "not assigned yet") {
    this.name = name;
    this.title = title;
  }

  stateName() {
    console.log(`${this.title} ${this.name}`);
  }
}
