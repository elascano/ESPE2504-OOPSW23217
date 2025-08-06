import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from caffeine_beverage import CaffeineBeverage


class Coffee(CaffeineBeverage):
    
    def brew(self):
        print("Dripping coffee through filter")
    
    def add_condiments(self):
        print("Adding sugar and milk")
    
    def wants_condiments(self):
        answer = self.get_user_input()
        if answer.lower().startswith("y"):
            return True
        else:
            return False
    
    def get_user_input(self):
        try:
            answer = input("Would you like milk and sugar with your coffee (y/n)? ")
            return answer if answer else "n"
        except:
            return "n"
