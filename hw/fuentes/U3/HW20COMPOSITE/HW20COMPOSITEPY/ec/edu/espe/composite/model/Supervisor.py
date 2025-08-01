from model.Employee import Employee

class Supervisor(Employee):
    def __init__(self):
        super().__init__()
        self.directReports = []

    def add(self, anEmployee):
        self.directReports.append(anEmployee)

    def stateName(self):
        super().stateName()
        for emp in self.directReports:
            emp.stateName()
