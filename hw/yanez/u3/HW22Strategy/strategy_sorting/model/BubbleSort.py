from model.SortingStrategy import SortingStrategy

class BubbleSort(SortingStrategy):
    def sort(self, data: list) -> list:
        print("Usando Bubble Sort")
        # Se hace copia para no alterar lista original
        arr = data.copy()
        n = len(arr)
        for i in range(n):
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
        return arr