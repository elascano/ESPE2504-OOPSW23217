const Stock = require('./Stock');

class IBM extends Stock {
    constructor(symbol, price) {
        super();
        this.symbol = symbol;
        this.price = price;
    }

    getPrice() {
        return this.price;
    }

    setPrice(price) {
        this.price = price;
        this.notifyObservers(price);
    }

    getSymbol() {
        return this.symbol;
    }

    setSymbol(symbol) {
        this.symbol = symbol;
        this.notifyObservers(symbol);
    }
}

module.exports = IBM;
