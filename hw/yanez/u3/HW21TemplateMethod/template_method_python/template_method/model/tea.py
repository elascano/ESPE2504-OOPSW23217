from .caffeine_beverage import CaffeineBeverage

class Tea(CaffeineBeverage):

    def brew(self):
        print("Steep the tea")

    def add_condiments(self):
        print("Adding lemon")

    def wants_condiments(self):
        answer = input("Would you like lemon with your tea (y/n)? ")
        return answer.strip().lower().startswith("y")
