const SortingStrategy = require('./SortingStrategy');

class QuickSort extends SortingStrategy {
    sort(data) {
        this.quickSort(data, 0, data.length - 1);
        return data;
    }
    
    quickSort(data, low, high) {
        if (low < high) {
            const pi = this.partition(data, low, high);
            this.quickSort(data, low, pi - 1);
            this.quickSort(data, pi + 1, high);
        }
    }
    
    partition(data, low, high) {
        const pivot = data[high];
        let i = low - 1;
        for (let j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                [data[i], data[j]] = [data[j], data[i]]; // Swap
            }
        }
        [data[i + 1], data[high]] = [data[high], data[i + 1]]; // Swap
        return i + 1;
    }
}

module.exports = QuickSort;