from model.Supervisor import Supervisor

class President(Supervisor):
    __instance = None

    def __new__(cls, aName=""):
        if cls.__instance is None:
            cls.__instance = super(President, cls).__new__(cls)
            cls.__instance.__initialized = False
        return cls.__instance

    def __init__(self, aName=""):
        if self.__initialized:
            self.name = aName
            return
        super().__init__()
        self.title = "President"
        self.name = aName
        President.__instance = self
        self.__initialized = True

    def stateName(self):
        super().stateName()
