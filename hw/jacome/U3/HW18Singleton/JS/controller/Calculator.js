const USTax = require('../model/USTax');

class Calculator {
    salesTotal(subtotal) {
        let tax = subtotal * USTax.getInstance().getTaxPercentage();
        return subtotal + tax;
    }
}

module.exports = Calculator;