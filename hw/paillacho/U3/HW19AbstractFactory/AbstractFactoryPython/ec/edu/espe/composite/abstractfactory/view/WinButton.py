"""
Windows Button implementation

@author PC
"""
from ec.edu.espe.composite.abstractfactory.model.Button import Button


class WinButton(Button):
    def paint(self):
        print(f"I'm a WinButton: {self.caption}")
