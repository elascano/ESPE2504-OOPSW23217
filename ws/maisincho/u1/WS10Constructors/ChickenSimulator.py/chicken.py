from datetime import datetime

class Chicken:
    def __init__(self, id=None, name=None, color=None, age=None, molting=None, born_on_date=None):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.molting = molting
        self.born_on_date = born_on_date

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_color(self):
        return self.color

    def set_color(self, color):
        self.color = color

    def get_age(self):
        return self.age

    def set_age(self, age):
        self.age = age

    def is_molting(self):
        return self.molting

    def set_molting(self, molting):
        self.molting = molting

    def get_born_on_date(self):
        return self.born_on_date

    def set_born_on_date(self, born_on_date):
        self.born_on_date = born_on_date

    def __str__(self):
        return (f"Chicken{{id={self.get_id()}, name={self.get_name()}, color={self.get_color()}, "
                f"age={self.get_age()}, molting={self.is_molting()}, bornOnDate={self.get_born_on_date()}}}")

    def do_stuff(self):
        print("Chicken is -->")
        self.cluck()
        self.wander()

    def cluck(self):
        print(f"Chicken name --> {self.get_name()}")
        print(f"Chicken date --> {self.get_born_on_date()}")
        print(f"Chicken --> {self.get_id()} is clucking")

    def wander(self):
        print(f"Chicken --> {self.get_id()} is wandering")

    def eat(self):
        print(f"Chicken --> {self.get_id()} is eating")

    def drink(self):
        print(f"Chicken --> {self.get_id()} is drinking")
