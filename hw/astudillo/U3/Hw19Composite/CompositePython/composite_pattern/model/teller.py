from .employee import Employee

class Teller(Employee):
    def __init__(self, name=None):
        super().__init__(name)
        self.title = "Teller"
    
    def state_name(self, title=None, name=None):
        if title is None and name is None:
            super().state_name(self.title, self.name)
        else:
            super().state_name(title, name)
