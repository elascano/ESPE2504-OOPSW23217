export class Chicken  {
  constructor(id, name, color, age, molting, bornOnDate) {
    this._id = id;
    this._name = name;
    this._color = color;
    this._age = age;
    this._molting = molting;
    this._bornOnDate = bornOnDate;
  }

  toString() {
    return `Chicken{id=${this.getId()}, name=${this.getName()}, color=${this.getColor()}, age=${this.getAge()}, molting=${this.isMolting()}, bornOnDate=${this.getBornOnDate()}}`;
  }

  duStuff() {
    console.log("Chicken is ...");
    this.#cluck();
    this.#wander();
  }

  // Métodos privados (disponibles en Node.js modernos o navegadores actualizados)
  #cluck() {
    console.log("chicken name --> " + this.getName());
    console.log("chicken date --> " + this.getBornOnDate());
    console.log(`The chicken ${this.getId()} is clucking`);
  }

  #wander() {
    console.log(`The chicken ${this.getId()} is wandering`);
  }

  #eat() {
    console.log(`The chicken ${this.getId()} is eating`);
  }

  #drink() {
    console.log(`The chicken ${this.getId()} is drinking`);
  }

  // Getters y setters
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