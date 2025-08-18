class IInvestor {
    update(stock, args) {
        throw new Error("Method 'update()' must be implemented.");
    }
}

module.exports = IInvestor;