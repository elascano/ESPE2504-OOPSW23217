import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from model.tea import Tea
from model.coffee import Coffee

def main():
    print("\nMaking tea ..")
    tea = Tea()
    tea.prepare_recipe()

    print("\nMaking coffee ...")
    coffee = Coffee()
    coffee.prepare_recipe()

if __name__ == "__main__":
    main()
