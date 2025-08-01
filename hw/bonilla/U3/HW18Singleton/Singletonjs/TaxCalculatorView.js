const readline = require('readline');
const Calculator = require('./Calculator');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

console.log("Tax Calculator");
console.log("Tax: 15%\n");

function askAmount() {
  rl.question("Ingresa el monto: ", (input) => {
    const saleAmount = parseFloat(input);
    if (saleAmount === 0) {
      rl.close();
    } else if (isNaN(saleAmount)) {
      console.log("Por favor, ingresa un número válido.");
      askAmount();
    } else {
      const total = Calculator.calculateTax(saleAmount);
      console.log(`Total con impuesto: ${total.toFixed(2)}\n`);
      askAmount();
    }
  });
}

askAmount();
