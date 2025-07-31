"""
Abstract Supervisor class (can have direct reports)
@author Carlos Paillacho
"""
from abc import ABC
from model.Employee import Employee


class Supervisor(Employee, ABC):
    def __init__(self, name: str = None):
        super().__init__(name)
        self.direct_reports: list[Employee] = []

    def state_name(self):
        # Print this supervisor first
        super().state_name()
        # Then each direct report
        for e in self.direct_reports:
            e.state_name()

    def add(self, an_employee: Employee):
        # Adds a direct report
        self.direct_reports.append(an_employee)
