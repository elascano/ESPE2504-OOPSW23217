"""
Linux Menu implementation

@author PC
"""
from .Menu import Menu


class LinuxMenu(Menu):
    def paint(self):
        print(f"I'm a LinuxMenu: {self.caption}")
