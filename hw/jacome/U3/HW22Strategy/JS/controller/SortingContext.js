const BubbleSort = require('../model/BubbleSort');
const InsertionSort = require('../model/InsertionSort');
const QuickSort = require('../model/QuickSort');

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
        return new BubbleSort(); // Default case
    }
}

module.exports = SortingContext;