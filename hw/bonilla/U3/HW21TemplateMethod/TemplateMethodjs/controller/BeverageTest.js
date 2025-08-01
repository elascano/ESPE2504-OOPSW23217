const Tea = require('../model/Tea');
const Coffee = require('../model/Coffee');

async function main() {
  const tea = new Tea();
  const coffee = new Coffee();

  console.log("\nMaking tea ..");
  await tea.prepareRecipe();

  console.log("\nMaking coffee ...");
  await coffee.prepareRecipe();
}

main();
