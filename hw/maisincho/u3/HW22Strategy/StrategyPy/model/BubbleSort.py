from typing import List
from model.SortingStrategy import SortingStrategy  

class BubbleSort(SortingStrategy):
    def sort(self, array: List[int]) -> None:
        n = len(array)
        for i in range(n - 1):
            for j in range(n - i - 1):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
