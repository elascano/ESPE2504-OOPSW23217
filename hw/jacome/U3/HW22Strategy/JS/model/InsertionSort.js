const SortingStrategy = require('./SortingStrategy');

class InsertionSort extends SortingStrategy {
    sort(data) {
        const n = data.length;
        for (let i = 1; i < n; ++i) {
            const key = data[i];
            let j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        return data;
    }
}

module.exports = InsertionSort;