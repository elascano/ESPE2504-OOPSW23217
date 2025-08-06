import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from controller.sorting_context import SortingContext

class SortApp:
    
    @staticmethod
    def main():
        sorting_context = SortingContext()
        
        print("Ingrese el numero de elementos: ", end="")
        n = int(input())
        
        data = []
        print(f"Ingrese {n} numeros:")
        
        for i in range(n):
            data.append(int(input()))
        
        print("Array original:")
        SortApp.print_array(data)
        
        sorted_data = sorting_context.sort(data.copy())
        
        print("Array ordenado:")
        SortApp.print_array(sorted_data)
    
    @staticmethod
    def print_array(array):
        for num in array:
            print(num, end=" ")
        print()

if __name__ == "__main__":
    SortApp.main()
