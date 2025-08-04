const Employee = require('./Employee');

class Teller extends Employee {
    constructor(aName) {
        super();
        if (aName) this.name = aName;
        this.title = "Teller";
    }
}

module.exports = Teller;