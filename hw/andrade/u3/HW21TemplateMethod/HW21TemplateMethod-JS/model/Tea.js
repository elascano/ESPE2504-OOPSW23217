const CaffeineBeverage = require('./CaffeineBeverage');

class Tea extends CaffeineBeverage {
    brew() {
        console.log("Steep the tea");
    }

    addCondiments() {
        console.log("Adding lemon");
    }
}

module.exports = Tea;