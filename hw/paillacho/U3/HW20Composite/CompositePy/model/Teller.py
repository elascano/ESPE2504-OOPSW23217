"""
Concrete Teller class
@author Carlos Paillacho
"""
from model.Employee import Employee


class Teller(Employee):
    def __init__(self, name: str):
        super().__init__(name)
        self.title = "Teller"
