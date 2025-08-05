"""
Base Employee class
@author Carlos Paillacho
"""


class Employee:
    def __init__(self, name: str = None):
        self.name = name or "not assigned yet"
        self.title = "not assigned yet"

    def state_name(self):
        # Prints title and name
        print(f"{self.title} {self.name}")
