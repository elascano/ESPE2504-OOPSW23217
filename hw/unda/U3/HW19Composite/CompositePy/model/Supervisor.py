from model.Employee import Employee

class Supervisor(Employee):
    def __init__(self, name=""):
        super().__init__(name)
        self.direct_reports = []

    def add(self, employee):
        self.direct_reports.append(employee)

    def state_name(self):
        super().state_name()
        for emp in self.direct_reports:
            emp.state_name()
