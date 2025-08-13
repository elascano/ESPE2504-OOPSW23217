from caffeine_beverage import CaffeineBeverage
import sys
import os

# Author: Carlos Paillacho

sys.path.append(os.path.dirname(os.path.abspath(__file__)))


class Tea(CaffeineBeverage):

    def brew(self):
        print("Steeping the tea")

    def add_condiments(self):
        print("Adding lemon")

    def wants_condiments(self):
        answer = self.get_user_input()
        if answer.lower().startswith("y"):
            return True
        else:
            return False

    def get_user_input(self):
        try:
            answer = input("Would you like lemon with your tea (y/n)? ")
            return answer if answer else "n"
        except:
            return "n"
