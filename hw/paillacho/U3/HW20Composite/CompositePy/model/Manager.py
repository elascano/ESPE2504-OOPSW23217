"""
Concrete Manager class
@author Carlos Paillacho
"""
from model.Supervisor import Supervisor


class Manager(Supervisor):
    def __init__(self, name: str):
        super().__init__(name)
        self.title = "Manager"
