from model.Employee import Employee

class Clerk(Employee):
    def __init__(self, name=""):
        super().__init__(name)
        self.title = "Clerk"

    def state_name(self):
        super().state_name()
