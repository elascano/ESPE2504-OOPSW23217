class Product {
  constructor(id, name, attr1, attr2) {
    this.id = id;
    this.name = name;
    this.attr1 = attr1;
    this.attr2 = attr2;
  }

  computeValue() {
    return this.attr1 * this.attr2; // lógica de negocio
  }
}
