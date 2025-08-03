from typing import List
from model.SortingStrategy import SortingStrategy 

class QuickSort(SortingStrategy):
    def sort(self, array: List[int]) -> None:
        self.quick_sort(array, 0, len(array) - 1)

    def quick_sort(self, array: List[int], low: int, high: int) -> None:
        if low < high:
            pi = self.partition(array, low, high)
            self.quick_sort(array, low, pi - 1)
            self.quick_sort(array, pi + 1, high)

    def partition(self, array: List[int], low: int, high: int) -> int:
        pivot = array[high]
        i = low - 1
        for j in range(low, high):
            if array[j] < pivot:
                i += 1
                array[i], array[j] = array[j], array[i]
        array[i + 1], array[high] = array[high], array[i + 1]
        return i + 1
