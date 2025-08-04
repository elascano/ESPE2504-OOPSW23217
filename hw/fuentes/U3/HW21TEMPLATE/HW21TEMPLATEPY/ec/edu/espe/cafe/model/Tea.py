from model.CaffeineBeverage import CaffeineBeverage

class Tea(CaffeineBeverage):
    def brew(self):
        print("Steeping the tea")

    def addCondiments(self):
        print("Adding lemon")

    def wantsCondiments(self):
        answer = self.getUserInput()
        return answer is not None and answer.lower().startswith("y")

    def getUserInput(self):
        try:
            answer = input("Would you like lemon with your tea (y/n)? ")
            return answer
        except Exception:
            print("Error reading input.")
            return None
