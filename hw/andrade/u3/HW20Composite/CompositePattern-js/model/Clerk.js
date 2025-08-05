const Employee = require('./Employee');

class Clerk extends Employee {
    constructor(aName) {
        super();
        if (aName) this.name = aName;
        this.title = "Clerk";
    }
}

module.exports = Clerk;