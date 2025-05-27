import { Chicken } from './Chicken.js';

function main() {
    const id = 1;
    const name = "Lucy";
    const color = "white and brown";
    const age = 5;
    const molting = true;
    const bornOnDate = new Date();

    const chicken = new Chicken(id, name, color, age, molting, bornOnDate);

    console.log("Micaela’s chicken data -->", chicken.toString());
    console.log("Micaela’s chicken data -->");
    chicken.doStuff();

    console.log(`chicken --> ${chicken.name} is ${chicken.color}`);

    chicken.age = 12;
    console.log(`chicken --> ${chicken.name} is ${chicken.age} year-old`);
    console.log("Micaela’s chicken data -->", chicken.toString());
}

main();
