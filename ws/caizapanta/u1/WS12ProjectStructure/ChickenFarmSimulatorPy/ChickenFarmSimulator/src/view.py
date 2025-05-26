#author:Tammy Caizapanta

from datetime import datetime
from model import Chicken

if __name__ == '__main__':
    chicken = Chicken(
       chicken_id=1,
       name="Lucy",
       color="white and brown",
       age=5,
       is_molting=True,
       born_on_date=datetime.now()
    )

    print("Tammy's chicken data -->",chicken)

    print(f"Chicken --> {chicken.name} is {chicken.color}")

    chicken.age = 12

    print(f"Chicken --> {chicken.name} is {chicken.age} months old")

    print(f"Chicken --> {chicken.name} is clucking")
    print(f"Chicken --> {chicken.name} is wandering")
    print(f"Chicken --> {chicken.name} is eating")
    print(f"Chicken --> {chicken.name} is drinking")

    cluck_message = chicken.cluck()
    wander_message = chicken.wander()
    eat_message = chicken.eat()
    drink_message = chicken.drink()