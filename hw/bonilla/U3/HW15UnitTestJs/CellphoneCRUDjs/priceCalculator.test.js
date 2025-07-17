import { calculatePrice } from './priceCalculator.js';

test('test 1', () => {
    expect(calculatePrice(11, 17)).toBeCloseTo(667.86);
});

test('test 2', () => {
    expect(calculatePrice(13, 15)).toBeCloseTo(696.43);
});

test('test 3', () => {
    expect(calculatePrice(7, 3)).toBeCloseTo(210);
});

test('test 4', () => {
    expect(calculatePrice(1, 9)).toBeCloseTo(90);
});

test('test 5', () => {
    expect(calculatePrice(0, 5)).toBeCloseTo(0);
});

test('test 6', () => {
    expect(calculatePrice(4, 6)).toBeCloseTo(240);
});

test('test 7', () => {
    expect(calculatePrice(3, 3)).toBeCloseTo(150);
});

test('test 8', () => {
    expect(calculatePrice(2, 4)).toBeCloseTo(133.33);
});

test('test 9', () => {
    expect(calculatePrice(5, 10)).toBeCloseTo(333.33, 2);
});

test('test 10', () => {
    expect(calculatePrice(10, 5)).toBeCloseTo(333.33, 3);
});