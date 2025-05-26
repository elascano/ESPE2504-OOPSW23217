#ChickenFarmSystem

class Poop:
    def __str__(self):
        return "This is poop from a chicken."


class Egg:
    def __init__(self):
        self._id = 0

    def set_id(self, egg_id):
        self._id = egg_id

    def get_id(self):
        return self._id

    def __str__(self):
        return f"Egg{{id={self._id}}}"


def main():
    print("This is a Chicken Farm Simulator")

    # Declarar e inicializar
    poop = Poop()
    egg = Egg()
    egg_two = Egg()
    egg_three = Egg()
    number_of_tires = 5
    name = "Maria Quiroz"

    # Métodos
    print("The number of tires is --->", number_of_tires)
    print("Chicken poop is -->", poop)
    print("My name is -->", name)

    egg.set_id(1)
    print("Chicken egg is -->", egg)
    print("Chicken egg id is -->", egg.get_id())

    egg_two.set_id(2)
    print("Chicken egg is -->", egg_two)
    print("Chicken egg id is -->", egg_two.get_id())

    egg_three.set_id(3)
    print("Chicken egg is -->", egg_three)
    print("Chicken egg id is -->", egg_three.get_id())


if __name__ == "__main__":
    main()
