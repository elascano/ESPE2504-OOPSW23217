import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..')))

from datetime import datetime
from ChicenFarmSimulator.model.chicken import Chicken

def main():
    id = 1
    color = "white and brown"
    name = "Lucy"
    age = 5
    molting = True
    date = datetime.now()

    chicken = Chicken(id, name, color, age, molting, date)

    print("Edison's chicken data -->", chicken)
    print("Edison's chicken data -->")
    chicken.do_stuff()

    print(f"chicken --> {chicken.name} is {chicken.color}")

    chicken.age = 12
    print(f"chicken --> {chicken.name} is {chicken.age} year-old")
    print("Edison's chicken data -->", chicken)

if __name__ == "__main__":
    main()
