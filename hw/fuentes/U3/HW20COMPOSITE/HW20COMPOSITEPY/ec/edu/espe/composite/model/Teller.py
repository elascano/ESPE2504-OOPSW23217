from model.Employee import Employee

class Teller(Employee):
    def __init__(self, aName=""):
        super().__init__()
        self.title = "Teller"
        self.name = aName
