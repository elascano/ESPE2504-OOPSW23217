const IInvestor = require('./IInvestor');

class Investor extends IInvestor {
    constructor(name) {
        super();
        this.name = name;
        this.observerState = undefined;
        this.stock = undefined;
    }

    update(stock, args) {
        console.log(`Notified observer ${this.name}`);
        if (typeof args === 'string') {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } else if (typeof args === 'number') {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}

module.exports = Investor;
