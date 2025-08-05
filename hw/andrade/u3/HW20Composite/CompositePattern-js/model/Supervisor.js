const Employee = require('./Employee');

class Supervisor extends Employee {
    constructor() {
        super();
        this.directReports = [];
    }
    
    stateName() {
        super.stateName();
        this.directReports.forEach(employee => {
            employee.stateName();
        });
    }
    
    add(anEmployee) {
        this.directReports.push(anEmployee);
    }
}

module.exports = Supervisor;