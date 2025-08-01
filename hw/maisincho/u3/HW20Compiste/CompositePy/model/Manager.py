from model.Supervisor import Supervisor  

class Manager(Supervisor):
    def __init__(self, name=None):
        super().__init__()
        self.title = "Manager"
        if name:
            self.name = name

    def state_name(self):
        super().state_name()
