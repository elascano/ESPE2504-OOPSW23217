const Supervisor = require('./Supervisor');

class Manager extends Supervisor {
    constructor(aName) {
        super();
        if (aName) this.name = aName;
        this.title = "Manager";
    }
}

module.exports = Manager;