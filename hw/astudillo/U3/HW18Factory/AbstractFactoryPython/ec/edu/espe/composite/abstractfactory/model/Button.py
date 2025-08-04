"""
Abstract Button class

@author PC
"""
from abc import ABC, abstractmethod


class Button(ABC):
    def __init__(self):
        self.caption = ""
    
    @abstractmethod
    def paint(self):
        pass
