from abc import ABC, abstractmethod

class Employee(ABC):
    def __init__(self, name=None):
        self.name = name if name else "not assigned yet"
        self.title = "not assigned yet"
    
    def state_name(self, title, name):
        print(f"{title} {name}")
