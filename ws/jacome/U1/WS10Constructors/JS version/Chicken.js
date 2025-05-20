export class Chicken {
    constructor(id, name, color, age, molting, bornOnDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.molting = molting;
        this.bornOnDate = bornOnDate;
    }

    toString() {
        return `Chicken{id: ${this.id}, name: ${this.name}, color: ${this.color}, age: ${this.age}, molting: ${this.molting}, bornOnDate: ${this.bornOnDate}}`;
    }

    doStuff() {
        console.log("Chicken is ...");
        this.cluck();
        this.wander();
    }

    cluck() {
        console.log(`chicken name --> ${this.name}`);
        console.log(`chicken date --> ${this.bornOnDate}`);
        console.log(`The chicken ${this.id} is clucking`);
    }

    wander() {
        console.log(`The chicken ${this.id} is wandering`);
    }

    eat() {
        console.log(`The chicken ${this.id} is eating`);
    }

    drink() {
        console.log(`The chicken ${this.id} is drinking`);
    }
}
