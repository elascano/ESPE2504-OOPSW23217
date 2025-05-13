from model.Egg import EggClass
from model.Poop import PoopClass

class ChickenFarmSystem:
    egg = EggClass(1)
    egg2 = EggClass(2)
    egg3 = EggClass(3)
    poop = PoopClass(1)
    numberOfTires = 5
    name = "Gerald"

    print("This a Chicken Farm Simulator")
    print("the number of tires is ", numberOfTires)
    print("the id poop is: ", poop.id)
    print("My name is ", name)
    print("the id egg is: ", egg.id)
    print("the id egg 2 is: ", egg2.id)
    print("the id egg 3 is: ", egg3.id)
