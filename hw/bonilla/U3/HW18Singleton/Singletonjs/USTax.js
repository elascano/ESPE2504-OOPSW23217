class USTax {
  static #instance;
  static #TAXRATE = 0.15;

  constructor() {
    if (USTax.#instance) {
      throw new Error("Use USTax.getInstance() to get the singleton instance.");
    }
  }

  static getInstance() {
    if (!USTax.#instance) {
      USTax.#instance = new USTax();
    }
    return USTax.#instance;
  }

  getSalesTotal(saleAmount) {
    return saleAmount + (saleAmount * USTax.#TAXRATE);
  }

  getTaxAmount(saleAmount) {
    return saleAmount * USTax.#TAXRATE;
  }

  getTaxRate() {
    return USTax.#TAXRATE;
  }
}

module.exports = USTax;
