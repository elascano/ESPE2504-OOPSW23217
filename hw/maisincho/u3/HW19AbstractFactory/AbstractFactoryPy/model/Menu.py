from abc import ABC, abstractmethod

class Menu(ABC):
    def __init__(self):
        self.caption = ""

    @abstractmethod
    def paint(self):
        pass