from ec.edu.espe.enterprise.model.Employee import Employee

class Supervisor(Employee):
    def __init__(self, name="not assigned yet", title="not assigned yet"):
        super().__init__(name, title)
        self.directReports = []

    def add(self, anEmployee):
        self.directReports.append(anEmployee)

    def state_name(self):
        super().state_name()
        for emp in self.directReports:
            emp.state_name()