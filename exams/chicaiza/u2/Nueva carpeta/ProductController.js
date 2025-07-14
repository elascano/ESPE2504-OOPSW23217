class ProductController {
  constructor() {
    this.products = [];
  }

  create(product) {
    this.products.push(product);
  }

  readAll() {
    return this.products;
  }

  readById(id) {
    return this.products.find(p => p.id === id);
  }

  update(id, updatedData) {
    const index = this.products.findIndex(p => p.id === id);
    if (index !== -1) {
      this.products[index] = { ...this.products[index], ...updatedData };
    }
  }

  delete(id) {
    this.products = this.products.filter(p => p.id !== id);
  }
}
