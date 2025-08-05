const CaffeineBeverage = require('./CaffeineBeverage');

class Coffee extends CaffeineBeverage {
    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }
}

module.exports = Coffee;