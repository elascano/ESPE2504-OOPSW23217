from controller.Employee import Employee

class Supervisor(Employee):
    def __init__(self, name="", title="Supervisor"):
        super().__init__(name, title)
        self.direct_reports = []  

    def state_name(self):
        super().state_name()
        if len(self.direct_reports) > 0:
            for employee in self.direct_reports:
                employee.state_name()

    def add(self, an_employee):
        self.direct_reports.append(an_employee)
