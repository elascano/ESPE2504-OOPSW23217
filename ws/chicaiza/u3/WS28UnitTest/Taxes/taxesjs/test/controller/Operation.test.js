// Operation.test.js
// Pruebas convertidas de OperationTest.java a JavaScript usando Jest

const Operation = require('../../src/controller/Operation');

describe('Operation', () => {
    test('add debe retornar la suma de dos números', () => {
        expect(Operation.add(1.2, 2.4)).toBeCloseTo(3.6);
    });
});
