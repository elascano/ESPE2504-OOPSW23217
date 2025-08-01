from controller.Employee import Employee  

class Teller(Employee):
    def __init__(self, name=None):
        super().__init__(name=name if name else "", title="Teller")

    def state_name(self):
        super().state_name()
