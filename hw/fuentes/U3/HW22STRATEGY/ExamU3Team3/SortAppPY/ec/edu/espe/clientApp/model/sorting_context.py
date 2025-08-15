from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort

class SortingContext:
    def __init__(self):
        self._strategy = None


    def sort(self, data: list[int], return_algorithm=False):
        size = len(data)
        self._strategy, algorithm = self._set_strategy(size)
        sorted_data = self._strategy.sort(data)
        if return_algorithm:
            return sorted_data, algorithm
        return sorted_data

    def _set_strategy(self, n: int):
        # BubbleSort for 2-5, InsertionSort for 6-10, QuickSort for >10
        if 2 <= n <= 5:
            return BubbleSort(), "BubbleSort"
        elif 6 <= n <= 10:
            return InsertionSort(), "InsertionSort"
        elif n > 10:
            return QuickSort(), "QuickSort"
        else:
            return BubbleSort(), "BubbleSort"  # fallback for n <= 1
