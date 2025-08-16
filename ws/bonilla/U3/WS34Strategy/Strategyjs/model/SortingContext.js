const BubbleSort = require('../controller/BubbleSort');
const InsertionSort = require('../controller/InsertionSort');
const QuickSort = require('../controller/QuickSort');

class SortingContext {
    constructor() {
        this.ss = null;
    }

    sort(data) {
        const size = data.length;
        this.ss = this.setSortStrategy(size);
        return this.ss.sort(data);
    }

    setSortStrategy(n) {
        if (n > 0 && n < 30) {
            return new BubbleSort();
        }
        if (n >= 30 && n < 100) {
            return new InsertionSort();
        }
        if (n >= 100) {
            return new QuickSort();
        }
    }
}

module.exports = SortingContext;
