from chicken import Chicken
from datetime import datetime

def main():
    id = 1
    color = "white and brown"
    name = "Lucy"
    age = 5
    molting = True
    date = datetime.now()

    chicken = Chicken(id, name, color, age, molting, date)

    print("Isaac's chicken data -->", chicken)
    print("Isaac's chicken data -->")
    chicken.do_stuff()

    print(f"Chicken --> {chicken.get_name()} is {chicken.get_color()}")

    chicken.set_age(12)
    print(f"Chicken --> {chicken.get_name()} is {chicken.get_age()} months old")
    print("Isaac's Chicken data -->", chicken)

if __name__ == "__main__":
    main()
