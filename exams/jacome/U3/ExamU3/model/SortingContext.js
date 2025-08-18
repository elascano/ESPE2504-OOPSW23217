import { BubbleSort } from './BubbleSort.js';
import { InsertionSort } from './InsertionSort.js';
import { QuickSort } from './QuickSort.js';

export class SortingContext {
  constructor() {
    this.strategy = null;
  }

  setSortStrategy(length) {
    if (length >= 2 && length <= 5) {
      this.strategy = new BubbleSort();
      return 'BubbleSort';
    } else if (length >= 6 && length <= 10) {
      this.strategy = new InsertionSort();
      return 'InsertionSort';
    } else {
      this.strategy = new QuickSort();
      return 'QuickSort';
    }
  }

  sort(arr) {
    if (!this.strategy) throw new Error('Sorting strategy not set.');
    return this.strategy.sort(arr);
  }
}