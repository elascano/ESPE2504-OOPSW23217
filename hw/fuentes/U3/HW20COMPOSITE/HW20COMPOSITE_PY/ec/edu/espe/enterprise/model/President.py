from ec.edu.espe.enterprise.model.Supervisor import Supervisor

class President(Supervisor):
    __instance = None

    def __init__(self, name="not assigned yet"):
        if President.__instance is not None:
            raise Exception("This class is a singleton!")
        super().__init__(name, "President")
        President.__instance = self

    @staticmethod
    def get_president(name):
        if President.__instance is None:
            President(name)
        President.__instance.name = name
        return President.__instance

    def state_name(self):
        super().state_name()