"""
Concrete Clerk class
@author Carlos Paillacho
"""
from model.Employee import Employee


class Clerk(Employee):
    def __init__(self, name: str):
        super().__init__(name)
        self.title = "Clerk"
