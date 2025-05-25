import { Egg } from "../ec.espe.edu.model/Egg.js";
import { Poop } from "../ec.espe.edu.model/Poop.js";

function main() {
    console.log("This is a Chicken Farm Simulator");

    // Declare
    let poop;
    let egg;
    let eggTwo;
    let eggThree;
    let numberOfTires;
    let name;

    // Initialize
    poop = new Poop();
    egg = new Egg();
    eggTwo = new Egg();
    eggThree = new Egg();
    numberOfTires = 5;
    name = "David";

    // Methods
    console.log("The number of tires is ---> " + numberOfTires);
    console.log("Chicken poop is -->", poop);
    console.log("My name is  --> " + name);
    
    egg.setId(1);
    console.log("Chicken egg is -->", egg);
    console.log("Chicken egg id is --> " + egg.getId());

    egg.setId(2);
    console.log("Chicken egg is -->", eggTwo);
    console.log("Chicken egg id is --> " + egg.getId());

    egg.setId(3);
    console.log("Chicken egg is -->", eggThree);
    console.log("Chicken egg id is --> " + egg.getId());
}

main();