const IInvestor = require('./IInvestor');

class Investor extends IInvestor {
    constructor(name) {
        super();
        this.name = name;
    }

    update(stock, args) {
        console.log(`Notified observer ${this.name}`);
        if (typeof args === 'string') {
            console.log(args);
        } else if (typeof args === 'number') {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}

module.exports = Investor;