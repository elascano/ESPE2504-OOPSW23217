from datetime import date

class Chicken:
    def __init__(self, id, name, color, age, molting, born_on_date):
        self._id = id
        self._name = name
        self._color = color
        self._age = age
        self._molting = molting
        self._born_on_date = born_on_date

    def __str__(self):
        return (f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
                f"age={self.age}, molting={self.molting}, bornOnDate={self.born_on_date}}}")

    def do_stuff(self):
        print("Chicken is..")
        self._cluck()
        self._wander()
        self._eat()
        self._drink()

    def _cluck(self):
        print(f"chicken name-->{self.name}")
        print(f"chicken date-->{self.born_on_date}")
        print(f"The chicken {self.id} is clucking")

    def _wander(self):
        print(f"The chicken {self.id} is wandering")

    def _eat(self):
        print(f"The chicken {self.id} is eating")

    def _drink(self):
        print(f"The chicken {self.id} is drinking")

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, value):
        self._color = value

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        self._age = value

    @property
    def molting(self):
        return self._molting

    @molting.setter
    def molting(self, value):
        self._molting = value

    @property
    def born_on_date(self):
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, value):
        self._born_on_date = value