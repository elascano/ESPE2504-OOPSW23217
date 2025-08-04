from model.sorting_strategy import SortingStrategy

class InsertionSort(SortingStrategy):
    def sort(self, data: list[int]) -> list[int]:
        result = data.copy()
        for i in range(1, len(result)):
            key = result[i]
            j = i - 1
            while j >= 0 and result[j] > key:
                result[j + 1] = result[j]
                j -= 1
            result[j + 1] = key
        print("Using InsertionSort")
        return result
