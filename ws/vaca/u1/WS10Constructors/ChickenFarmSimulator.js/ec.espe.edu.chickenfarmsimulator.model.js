export class Chicken {
    constructor(id, name, color, age, molting, bornOnDate) {
        this._id = id;
        this._name = name;
        this._color = color;
        this._age = age;
        this._molting = molting;
        this._bornOnDate = bornOnDate;
    }

    toString() {
        return `Chicken { 
            id= ${this.id}, 
            name= ${this.name}, 
            color= ${this.color}, 
            age= ${this.age}, 
            molting= ${this.molting}, 
            bornOnDate= ${this.bornOnDate.toLocaleDateString()}
        }`;
    }

    getId() {
        return this._id;
    }

    setId(id) {
        this._id = id;
    }
    
    getName() {
        return this._name;
    }

    setName(name) {
        this._name = name;
    }

    getColor() {
        return this._color;
    }

    setColor(color) {
        this._color = color;
    }

    getAge() {
        return this._age;
    }

    setAge(age) {
        this._age = age;
    }

    isMolting() {
        return this._molting;
    }

    setMolting(molting) {
        this._molting = molting;
    }

    getBornOnDate() {
        return this._bornOnDate;
    }

    setBornOnDate(bornOnDate) {
        this._bornOnDate = bornOnDate;
    }
}