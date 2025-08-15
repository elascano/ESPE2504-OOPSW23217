from model.sorting_strategy import SortingStrategy

class QuickSort(SortingStrategy):
    def sort(self, data: list[int]) -> list[int]:
        result = data.copy()
        self._quick_sort(result, 0, len(result) - 1)
        print("Using QuickSort")
        return result

    def _quick_sort(self, arr: list[int], low: int, high: int):
        if low < high:
            pi = self._partition(arr, low, high)
            self._quick_sort(arr, low, pi - 1)
            self._quick_sort(arr, pi + 1, high)

    def _partition(self, arr: list[int], low: int, high: int) -> int:
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1
