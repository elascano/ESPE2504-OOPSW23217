const Supervisor = require('./Supervisor');

class Manager extends Supervisor {
  constructor(aName) {
    super();
    this.title = "Manager";
    if (aName) this.name = aName;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = Manager;
