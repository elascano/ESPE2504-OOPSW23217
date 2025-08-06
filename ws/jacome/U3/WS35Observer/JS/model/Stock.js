class Stock {
    constructor() {
        this.investors = [];
    }

    addObserver(investor) {
        this.investors.push(investor);
    }

    deleteObserver(investor) {
        const index = this.investors.indexOf(investor);
        if (index !== -1) {
            this.investors.splice(index, 1);
        }
    }

    notifyObservers(args) {
        for (const investor of this.investors) {
            investor.update(this, args);
        }
    }

    getSymbol() {
        throw new Error("Method 'getSymbol()' must be implemented.");
    }

    getPrice() {
        throw new Error("Method 'getPrice()' must be implemented.");
    }
}

module.exports = Stock;