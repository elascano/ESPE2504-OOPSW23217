const Supervisor = require('./Supervisor');

class President extends Supervisor {
  static presidentInstance = null;

  constructor(aName) {
    super();
    this.title = "President";
    if (aName) this.name = aName;
  }

  static getPresident(aName) {
    if (!President.presidentInstance) {
      President.presidentInstance = new President(aName);
    } else {
      President.presidentInstance.name = aName;
    }
    return President.presidentInstance;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = President;
