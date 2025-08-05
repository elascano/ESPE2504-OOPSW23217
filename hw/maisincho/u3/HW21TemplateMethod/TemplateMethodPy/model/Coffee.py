from model.CaffeineBeverage import CaffeineBeverage

class Coffee(CaffeineBeverage):
    def brew(self):
        print("Dripping coffee through filter")

    def add_condiments(self):
        print("Adding sugar and milk")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith('y')

    def get_user_input(self):
        try:
            answer = input("Would you like milk and sugar (y/n)? ")
        except Exception as e:
            print(f"Error reading input: {e}")
            answer = "no"
        return answer
