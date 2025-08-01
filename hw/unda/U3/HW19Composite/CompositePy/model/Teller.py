from model.Employee import Employee

class Teller(Employee):
    def __init__(self, name=""):
        super().__init__(name)
        self.title = "Teller"

    def state_name(self):
        super().state_name()
