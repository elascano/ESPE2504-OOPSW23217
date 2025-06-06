const fs = require('fs');
const readline = require('readline');

class Truck {
    constructor(numberOfWheels, color, brand, year, hasTrailer, plate, registration, fuelCapacity, engineType, mileage) {
        this.numberOfWheels = numberOfWheels;
        this.color = color;
        this.brand = brand;
        this.year = year;
        this.hasTrailer = hasTrailer;
        this.plate = plate;
        this.registration = registration;
        this.fuelCapacity = fuelCapacity;
        this.engineType = engineType;
        this.mileage = mileage;
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const questions = [
    "How many wheels does it have?: ",
    "What color it is?: ",
    "Enter truck's brand: ",
    "Enter truck's year: ",
    "Does it have a trailer?: ",
    "Enter truck's plate: ",
    "Enter truck's registration: ",
    "What's its fuel capacity?: ",
    "What kind of engine does it have?: ",
    "Enter truck's mileage: ",
];

let answers = [];

function askQuestion(i) {
    if (i < questions.length) {
        rl.question(questions[i], (answer) => {
            answers.push(answer);
            askQuestion(i + 1);
        });
    } else {
        const truck = new Truck(
            parseInt(answers[0]),         // numberOfWheels
            answers[1],                   // color
            answers[2],                   // brand
            parseInt(answers[3]),         // year
            answers[4].toLowerCase() === 'yes', // hasTrailer
            answers[5],                   // plate
            answers[6],                   // registration
            parseInt(answers[7]),       // fuelCapacity
            answers[8],                   // engineType
            parseInt(answers[9])          // mileage
        );

        // Guardar en archivo JSON
        fs.writeFile('truckData.json', JSON.stringify(truck, null, 2), (err) => {
            if (err) throw err;
            console.log('Datos guardados en truck.json');
            rl.close();
        });
    }
}

askQuestion(0);