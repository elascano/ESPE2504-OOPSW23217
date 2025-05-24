import { Chicken } from 'ec.espe.edu.chickenfarmsimulator.model.js';

function main() {
  let id = 1;
  let name = "Lucy";
  let color = "white and brown";
  let age = 5;
  let molting = true;
  let bornOnDate = new Date();

  let chicken = new Chicken(id, name, color, age, molting, bornOnDate);

  console.log("Kevin's chicken data --> " + chicken.toString());
}

main();