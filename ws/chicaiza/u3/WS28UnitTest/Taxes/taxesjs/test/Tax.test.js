// Tax.test.js
// Pruebas convertidas de TaxTest.java a JavaScript usando Jest

const Tax = require('../Tax');

describe('Tax', () => {
    test('computeTax debe retornar 0.0 si charged es false', () => {
        const tax = new Tax();
        expect(tax.computeTax(100.0, 15.0, false)).toBe(0.0);
    });

    test('computeIce debe retornar 0.0', () => {
        const tax = new Tax();
        expect(tax.computeIce(0.0)).toBe(0.0);
    });

    test('computeTax con charged false debe retornar 0.0', () => {
        const tax = new Tax();
        expect(tax.computeTax(100.0, 15.0, false)).toBe(0.0);
    });
});
