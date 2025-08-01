const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Coffee extends CaffeineBeverage {
  brew() {
    console.log("Dripping coffee through filter");
  }

  addCondiments() {
    console.log("Adding sugar and milk");
  }

  wantsCondiments() {
    return new Promise(resolve => {
      const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
      });

      rl.question("Would you like milk and sugar with your coffee (y/n)? ", answer => {
        rl.close();
        resolve(answer.toLowerCase().startsWith('y'));
      });
    });
  }
}

module.exports = Coffee;
