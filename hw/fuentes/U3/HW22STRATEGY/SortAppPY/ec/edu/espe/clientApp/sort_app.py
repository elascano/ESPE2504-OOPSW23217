from model.sorting_context import SortingContext

def main():
    data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3]
    context = SortingContext()
    sorted_data = context.sort(data)
    print("Sorted array:", sorted_data)

if __name__ == "__main__":
    main()
