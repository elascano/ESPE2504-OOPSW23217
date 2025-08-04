"""
Calculator class
@author Astudillo
"""
import sys
import os

# Add the project root to the Python path
current_dir = os.path.dirname(os.path.abspath(__file__))
project_root = os.path.join(current_dir, '..', '..', '..', '..', '..')
sys.path.insert(0, project_root)

from ec.edu.espe.singleton.model.ustax import USTax


class Calculator:
    
    @staticmethod
    def main():
        tax = USTax.get_instance()
        print("Sales Total: " + str(tax.sales_total()))


if __name__ == "__main__":
    Calculator.main()
