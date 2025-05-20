#author:Tammy Caizapanta

from dataclasses import dataclass

@dataclass
class Chicken:
    def __init__(self, chicken_id,name,color,age,is_molting,born_on_date):
        self.chicken_id=chicken_id
        self.name=name
        self.color=color
        self.age=age
        self.is_molting=is_molting
        self.born_on_date=born_on_date

    def __str__(self):
        return (f"Chicken{{id={self.chicken_id}, name={self.name}, color={self.color}, age={self.age}, "
                f"is_molting={self.is_molting}, born_on_date={self.born_on_date}}}")
    def do_stuff(self):
        print("Chicken is -->")

    def cluck(self):
        print(f"Chicken name --> {self.name}")
        print(f"Chicken date --> {self.born_on_date}")
        print(f"Chicken --> {self.chicken_id} is clucking")

    def wander(self):
        print(f"Chicken --> {self.chicken_id} is wandering")

    def eat(self):
        print(f"Chicken --> {self.chicken_id} is eating")

    def drink(self):
        print(f"Chicken --> {self.chicken_id} is drinking")