const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Tea extends CaffeineBeverage {
  brew() {
    console.log("Steep the tea");
  }

  addCondiments() {
    console.log("Adding lemon");
  }

  wantsCondiments() {
    return new Promise(resolve => {
      const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
      });

      rl.question("Would you like lemon with your tea (y/n)? ", answer => {
        rl.close();
        resolve(answer.toLowerCase().startsWith('y'));
      });
    });
  }
}

module.exports = Tea;
