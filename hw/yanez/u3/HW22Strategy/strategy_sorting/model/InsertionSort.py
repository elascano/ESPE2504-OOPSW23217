from model.SortingStrategy import SortingStrategy

class InsertionSort(SortingStrategy):
    def sort(self, data: list) -> list:
        print("Usando Insertion Sort")
        arr = data.copy()
        for i in range(1, len(arr)):
            key = arr[i]
            j = i - 1
            while j >= 0 and key < arr[j]:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
        return arr