class Tax {
    computeTax(basePrice, percentage, charged) {
        if (!charged) {
            return 0.0;
        }
        return basePrice * percentage / 100;
    }

    computeIce(basePrice) {
        // Placeholder para ICE (similar a Java)
        return 0.0;
    }
}

module.exports = Tax;