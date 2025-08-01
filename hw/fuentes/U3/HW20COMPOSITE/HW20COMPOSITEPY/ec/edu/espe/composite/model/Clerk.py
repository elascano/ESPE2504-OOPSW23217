from model.Employee import Employee

class Clerk(Employee):
    def __init__(self, aName=""):
        super().__init__()
        self.title = "Clerk"
        self.name = aName
