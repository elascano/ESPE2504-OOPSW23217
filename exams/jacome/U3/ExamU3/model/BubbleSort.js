import { SortingStrategy } from './SortingStrategy.js';

export class BubbleSort extends SortingStrategy {
  sort(arr) {
    const a = [...arr];
    for (let i = 0; i < a.length - 1; i++) {
      for (let j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          [a[j], a[j + 1]] = [a[j + 1], a[j]];
        }
      }
    }
    return a;
  }
}
