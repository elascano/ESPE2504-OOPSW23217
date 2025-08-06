from typing import List
from model.BubbleSort import BubbleSort
from model.InsertionSort import InsertionSort
from model.QuickSort import QuickSort
from model.SortingStrategy import SortingStrategy

class SortingContext:
    def __init__(self):
        self.strategy: SortingStrategy = None
        self.strategy_name: str = ""

    def set_sort_strategy(self, array: List[int]) -> None:
        if len(array) < 30:
            self.strategy = BubbleSort()
            self.strategy_name = "Bubble Sort"
        elif len(array) < 100:
            self.strategy = InsertionSort()
            self.strategy_name = "Insertion Sort"
        else:
            self.strategy = QuickSort()
            self.strategy_name = "Quick Sort"

    def sort_array(self, array: List[int]) -> None:
        print("Original array:", array)
        self.set_sort_strategy(array)
        if self.strategy:
            self.strategy.sort(array)
            print("Sorted array:", array)
            print("Sorting strategy used:", self.strategy_name)
        else:
            print("No sorting strategy set.")
