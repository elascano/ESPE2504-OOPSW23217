class USTax {
    constructor(taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    static getInstance() {
        if (!USTax.instance) {
            USTax.instance = new USTax(0.2);
        }
        return USTax.instance;
    }

    static setInstance(newInstance) {
        if (newInstance) {
            USTax.instance = newInstance;
        } else {
            console.log("Cannot set null instance");
        }
    }

    getTaxPercentage() {
        return this.taxPercentage;
    }

    setTaxPercentage(taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}

module.exports = USTax;