import { Chicken } from "../ec.espe.edu.model/Chicken.js"

// Simulación del main
function main() {
  const id = 1;
  const name = "Lucy";
  const color = "white and brown";
  const age = 5;
  const molting = true;
  const bornOnDate = new Date(); // fecha actual

  const chicken = new Chicken(id, name, color, age, molting, bornOnDate);

  console.log("Edison's chicken data --> " + chicken.toString());
  console.log("Edison's chicken data -->");
  chicken.duStuff();

  console.log(`chicken --> ${chicken.getName()} is ${chicken.getColor()}`);

  chicken.setAge(12);
  console.log(`chicken --> ${chicken.getName()} is ${chicken.getAge()} years old`);
  console.log("Edison's chicken data --> " + chicken.toString());
}

// Ejecutar el programa
main();
