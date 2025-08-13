from .sorting_strategy import SortingStrategy

# Author: Carlos Paillacho


class QuickSort(SortingStrategy):

    def sort(self, data):
        self._quick_sort(data, 0, len(data) - 1)
        return data

    def _quick_sort(self, data, low, high):
        if low < high:
            pi = self._partition(data, low, high)
            self._quick_sort(data, low, pi - 1)
            self._quick_sort(data, pi + 1, high)

    def _partition(self, data, low, high):
        pivot = data[high]
        i = low - 1
        for j in range(low, high):
            if data[j] < pivot:
                i += 1
                data[i], data[j] = data[j], data[i]
        data[i + 1], data[high] = data[high], data[i + 1]
        return i + 1
