from controller.SortingContext import SortingContext

if __name__ == "__main__":
    data = [3, 5, 4, 6, 7, 9, 5, 6, 7, 5, 1, 3]

    print("Lista original:", data)

    context = SortingContext()
    sorted_data = context.sort(data)

    print("Lista ordenada:", sorted_data)