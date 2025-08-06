"""
Windows Menu implementation

@author PC
"""
from .Menu import Menu


class WinMenu(Menu):
    def paint(self):
        print(f"I'm a WinMenu: {self.caption}")
