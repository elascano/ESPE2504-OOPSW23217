const Tax = require('../controller/Tax');

describe('Clase Tax', () => {
    let tax;

    // Se ejecuta antes de cada prueba
    beforeEach(() => {
        tax = new Tax();
    });

    test('computeTax return 0 if "charged" is false', () => {
        expect(tax.computeTax(100.0, 15.0, false)).toBe(0.0);
    });

    test('computeIce return 0 (placeholder)', () => {
        expect(tax.computeIce(100.0)).toBe(0.0);
    });
});