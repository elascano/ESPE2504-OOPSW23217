from model.Supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, name=""):
        super().__init__(name)
        self.title = "Manager"

    def state_name(self):
        super().state_name()
