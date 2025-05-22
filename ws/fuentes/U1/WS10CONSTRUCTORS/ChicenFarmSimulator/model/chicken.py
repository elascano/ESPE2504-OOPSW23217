from datetime import datetime

class Chicken:
    def __init__(self, id, name, color, age, molting, born_on_date):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.molting = molting
        self.born_on_date = born_on_date

    def __str__(self):
        return (f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
                f"age={self.age}, molting={self.molting}, bornOnDate={self.born_on_date}}}")

    def do_stuff(self):
        print("Chicken is ...")
        self.__cluck()
        self.__wander()

    def __cluck(self):
        print(f"chicken name --> {self.name}")
        print(f"chicken date --> {self.born_on_date}")
        print(f"The chicken {self.id} is clucking")

    def __wander(self):
        print(f"The chicken {self.id} is wandering")

    def __eat(self):
        print(f"The chicken {self.id} is eating")

    def __drink(self):
        print(f"The chicken {self.id} is drinking")
