// Tax.js
// Conversión de Tax.java a JavaScript

class Tax {
    computeTax(basePrice, percentage, charged) {
        if (!charged) {
            return 0.0;
        } else {
            return basePrice * percentage / 100;
        }
    }

    computeIce(basePrice) {
        // Aquí iría la lógica para calcular el ICE
        return 0.0;
    }
}

module.exports = Tax;
