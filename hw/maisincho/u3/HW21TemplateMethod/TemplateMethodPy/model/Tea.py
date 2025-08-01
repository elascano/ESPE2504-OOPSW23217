from model.CaffeineBeverage import CaffeineBeverage

class Tea(CaffeineBeverage):
    def brew(self):
        print("Steep the tea")

    def add_condiments(self):
        print("Adding Lemon")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith('y')

    def get_user_input(self):
        try:
            answer = input("Would you like lemon on your tea (y/n)? ")
        except Exception as e:
            print(f"Error reading input: {e}")
            answer = "no"
        return answer
