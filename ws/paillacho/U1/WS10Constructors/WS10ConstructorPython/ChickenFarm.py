from datetime import datetime

class Chicken:
    def __init__(self, id: int, name: str, color: str, age: int, molting: bool, born_on_date: datetime):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.molting = molting
        self.born_on_date = born_on_date

    # Getters and setters
    @property
    def id(self) -> int:
        return self._id

    @id.setter
    def id(self, value: int):
        self._id = value

    @property
    def name(self) -> str:
        return self._name

    @name.setter
    def name(self, value: str):
        self._name = value

    @property
    def color(self) -> str:
        return self._color

    @color.setter
    def color(self, value: str):
        self._color = value

    @property
    def age(self) -> int:
        return self._age

    @age.setter
    def age(self, value: int):
        self._age = value

    @property
    def molting(self) -> bool:
        return self._molting

    @molting.setter
    def molting(self, value: bool):
        self._molting = value

    @property
    def born_on_date(self) -> datetime:
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, value: datetime):
        self._born_on_date = value

    def do_stuff(self):
        self._cluck()
        self._wander()
        self._eat()
        self._drink()

    def _cluck(self):
        print(f"Chicken name --> {self.name}")
        print(f"Chicken date --> {self.born_on_date}")
        print(f"Chicken --> {self.id} is clucking")

    def _wander(self):
        print(f"Chicken --> {self.id} is wandering")

    def _eat(self):
        print(f"Chicken --> {self.id} is eating")

    def _drink(self):
        print(f"Chicken --> {self.id} is drinking")

    def __str__(self):
        return (
            f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
            f"age={self.age}, molting={self.molting}, born_on_date={self.born_on_date}}}"
        )


def main():
    id = 1
    color = "white and brown"
    name = "Lucy"
    age = 5
    molting = True
    born_on_date = datetime.now()

    chicken = Chicken(id, name, color, age, molting, born_on_date)
    print(f"Maria Quiroz's chicken data --> {chicken}")
    chicken.do_stuff()

    print(f"Chicken --> {chicken.name} is {chicken.color}")

    chicken.age = 12
    print(f"Chicken --> {chicken.name} is {chicken.age} months old")
    print(f"Maria Quiroz's Chicken data --> {chicken}")



main()
