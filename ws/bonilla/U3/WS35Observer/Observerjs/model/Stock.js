class Stock {
    constructor() {
        this.symbol = undefined;
        this.price = undefined;
        this.investors = [];
    }

    addObserver(iinvestor) {
        this.investors.push(iinvestor);
    }

    deleteObserver(iinvestor) {
        this.investors = this.investors.filter(i => i !== iinvestor);
    }

    notifyObservers(args) {
        for (const investor of this.investors) {
            investor.update(this, args);
        }
    }

    getSymbol() {
        return this.symbol;
    }

    setSymbol(symbol) {
        this.symbol = symbol;
    }

    getPrice() {
        return this.price;
    }

    setPrice(price) {
        this.price = price;
    }

    getInvestors() {
        return this.investors;
    }

    setInvestors(investors) {
        this.investors = investors;
    }
}

module.exports = Stock;
