const Employee = require('./Employee');

class Teller extends Employee {
  constructor(aName) {
    super();
    this.title = "Teller";
    if (aName) this.name = aName;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = Teller;
