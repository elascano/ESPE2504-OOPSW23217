from .caffeine_beverage import CaffeineBeverage

class Coffee(CaffeineBeverage):

    def brew(self):
        print("Dripping coffee through filter")

    def add_condiments(self):
        print("Adding sugar and milk")

    def wants_condiments(self):
        answer = input("Would you like milk and sugar with your coffee (y/n)? ")
        return answer.strip().lower().startswith("y")
