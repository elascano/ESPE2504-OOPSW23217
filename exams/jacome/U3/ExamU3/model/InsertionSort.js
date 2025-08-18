import { SortingStrategy } from './SortingStrategy.js';

export class InsertionSort extends SortingStrategy {
  sort(arr) {
    const a = [...arr];
    for (let i = 1; i < a.length; i++) {
      let key = a[i];
      let j = i - 1;
      while (j >= 0 && a[j] > key) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = key;
    }
    return a;
  }
}
