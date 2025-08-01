const Calculator = require('../controller/Calculator');
const USTax = require('../model/USTax');

const calculator = new Calculator();

let subtotal = 10.0;
let total = calculator.salesTotal(subtotal);
console.log("The total is --> $" + total);

USTax.getInstance().setTaxPercentage(0.15);
total = calculator.salesTotal(subtotal);
console.log("The total with 15% tax is --> $" + total);