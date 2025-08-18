import { SortingStrategy } from './SortingStrategy.js';

export class QuickSort extends SortingStrategy {
  sort(arr) {
    if (arr.length <= 1) return arr;
    const pivot = arr[Math.floor(arr.length / 2)];
    const left = arr.filter(x => x < pivot);
    const middle = arr.filter(x => x === pivot);
    const right = arr.filter(x => x > pivot);
    return this.sort(left).concat(middle, this.sort(right));
  }
}
