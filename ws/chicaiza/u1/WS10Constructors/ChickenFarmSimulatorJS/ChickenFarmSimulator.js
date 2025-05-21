const Chicken = require('./Chicken');

function main() {
  const id = 1;
  const name = "Lucy";
  const color = "white and brown";
  const age = 5;
  const molting = true;
  const date = new Date();

  const chicken = new Chicken(id, name, color, age, molting, date);

  console.log("Chicaiza's chicken data --> " + chicken.toString());
  console.log("Chicaiza's chicken data -->");
  chicken.doStuff();

  console.log(`chicken --> ${chicken.name} is ${chicken.color}`);

  chicken.age = 12;

  console.log(`chicken --> ${chicken.name} is ${chicken.age} years-old`);
  console.log("Chicaiza's chicken data --> " + chicken.toString());
}

main();
