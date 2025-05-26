from ec.edu.espe.model.Chicken import Chicken
from datetime import date

if __name__ == "__main__":
    chicken_id = 1
    color = "white and brown"
    name = "Lucy"
    age = 5
    molting = True
    today = date.today()

    chicken = Chicken(chicken_id, name, color, age, molting, today)

    print(f"Fuentes's chicken data --> {chicken}")
    print("Fuentes's chicken data -->")
    chicken.do_stuff()

    print(f"chicken --> {chicken.name} is {chicken.color}")

    chicken.age = 12
    print(f"chicken --> {chicken.name} is {chicken.age} years-old")
    print(f"Fuentes's chicken data --> {chicken}")