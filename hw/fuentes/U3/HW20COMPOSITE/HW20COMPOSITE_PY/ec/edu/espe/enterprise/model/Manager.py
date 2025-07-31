from ec.edu.espe.enterprise.model.Supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, name="not assigned yet"):
        super().__init__(name, "Manager")

    def state_name(self):
        super().state_name()