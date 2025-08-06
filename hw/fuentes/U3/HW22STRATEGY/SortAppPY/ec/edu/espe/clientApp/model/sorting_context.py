from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort

class SortingContext:
    def __init__(self):
        self._strategy = None

    def sort(self, data: list[int]) -> list[int]:
        size = len(data)
        self._strategy = self._set_strategy(size)
        return self._strategy.sort(data)

    def _set_strategy(self, n: int):
        if 0 < n < 30:
            return BubbleSort()
        elif 30 <= n < 100:
            return InsertionSort()
        else:
            return QuickSort()
