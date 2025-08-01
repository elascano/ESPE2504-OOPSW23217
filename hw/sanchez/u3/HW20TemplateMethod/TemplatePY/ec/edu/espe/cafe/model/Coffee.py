from model.CaffeineBeverage import CaffeineBeverage

class Coffee(CaffeineBeverage):
    def brew(self):
        print("Dripping Coffee through filter")

    def addCondiments(self):
        print("Adding Sugar and Milk")

    def wantsCondiments(self):
        answer = self.getUserInput()
        return answer is not None and answer.lower().startswith("y")

    def getUserInput(self):
        try:
            answer = input("Would you like milk an dsugar with your coffee (y/n)? ")
            return answer
        except Exception:
            print("Error reading input.")
            return None
