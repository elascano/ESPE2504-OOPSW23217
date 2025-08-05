from model.caffeine_beverage import CaffeineBeverage

class Tea(CaffeineBeverage):
    def brew(self):
        print("Steep the tea")

    def add_condiments(self):
        print("Adding lemon")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith("y")

    def get_user_input(self):
        return input("Would you like lemon with your tea (y/n)? ")
