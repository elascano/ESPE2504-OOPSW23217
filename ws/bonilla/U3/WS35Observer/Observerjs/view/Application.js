const Investor = require('../model/Investor');
const IBM = require('../model/IBM');

function main() {
    const s = new Investor("Sorros");
    const b = new Investor("Berkshire");

    const ibm = new IBM("IBM", 120.00);
    ibm.addObserver(s);
    ibm.addObserver(b);
    ibm.setPrice(120.10);
    ibm.setPrice(121.00);
    ibm.setPrice(120.50);
    ibm.setPrice(120.75);
    ibm.setSymbol("IBMTEST");
}

main();
