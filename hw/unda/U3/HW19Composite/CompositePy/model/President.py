from model.Supervisor import Supervisor

class President(Supervisor):
    _president_instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._president_instance:
            cls._president_instance = super(President, cls).__new__(cls)
        return cls._president_instance

    def __init__(self, name=""):
        if not hasattr(self, '_initialized'):
            super().__init__(name)
            self.title = "President"
            self._initialized = True
        if name:
            self.name = name

    def state_name(self):
        super().state_name()

    @classmethod
    def get_president(cls, name):
        instance = cls(name)
        return instance
