from model.Supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, aName=""):
        super().__init__()
        self.title = "Manager"
        self.name = aName

    def stateName(self):
        super().stateName()
