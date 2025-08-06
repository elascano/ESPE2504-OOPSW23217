"""
Linux Button implementation

@author PC
"""
from ec.edu.espe.composite.abstractfactory.model.Button import Button


class LinuxButton(Button):
    def paint(self):
        print(f"I'm a LinuxButton: {self.caption}")
