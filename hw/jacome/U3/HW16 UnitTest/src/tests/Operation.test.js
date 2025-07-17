const Operation = require('../controller/Operation');

test('Suma 1.2 + 2.4 debe ser 3.6', () => {
    expect(Operation.add(1.2, 2.4)).toBeCloseTo(3.6); // toBeCloseTo evita errores de redondeo con floats
});