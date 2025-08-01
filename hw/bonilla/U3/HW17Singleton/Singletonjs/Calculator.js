const USTax = require('./USTax');

class Calculator {
  static calculateTax(sale) {
    const tax = USTax.getInstance();
    return tax.getSalesTotal(sale);
  }
}

module.exports = Calculator;
