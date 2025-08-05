import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from tea import Tea
from coffee import Coffee


class BeverageTest:
    
    @staticmethod
    def main():
        tea = Tea()
        coffee = Coffee()
        
        print("Making Tea ...")
        tea.prepare_recipe()
        
        print("\nMaking coffee ...")
        coffee.prepare_recipe()


if __name__ == "__main__":
    BeverageTest.main()
