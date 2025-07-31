from .employee import Employee

class Supervisor(Employee):
    def __init__(self, name=None):
        super().__init__(name)
        self.direct_reports = []
    
    def state_name(self, title, name):
        super().state_name(title, name)
        if self.direct_reports:
            for emp in self.direct_reports:
                emp.state_name(emp.title, emp.name)
    
    def add(self, employee):
        self.direct_reports.append(employee)
