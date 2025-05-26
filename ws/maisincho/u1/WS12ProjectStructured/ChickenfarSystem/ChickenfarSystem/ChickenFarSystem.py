from egg_model import Egg
from poop import Poop

def main():
    print("This is a Chicken Farm Simulator")

    poop = Poop()
    egg = Egg()
    egg_two = Egg()
    egg_three = Egg()
    number_of_tires = 5
    name = "David"

    print(f"The number of tires is ---> {number_of_tires}")
    print(f"Chicken poop is --> {poop}")
    print(f"My name is  --> {name}")

    egg.set_id(1)
    print(f"Chicken egg is --> {egg}")
    print(f"Chicken egg id is --> {egg.get_id()}")

    egg.set_id(2)
    print(f"Chicken egg is --> {egg_two}")
    print(f"Chicken egg id is --> {egg.get_id()}")

    egg.set_id(3)
    print(f"Chicken egg is --> {egg_three}")
    print(f"Chicken egg id is --> {egg.get_id()}")

if __name__ == "__main__":
    main()
