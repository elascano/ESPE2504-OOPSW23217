from model.Supervisor import Supervisor  

class President(Supervisor):
    _president_instance = None  # instance

    def __new__(cls, *args, **kwargs):
        #only instance
        if cls._president_instance is None:
            cls._president_instance = super().__new__(cls)
        return cls._president_instance

    def __init__(self, name=None):
        if not hasattr(self, '_initialized'):
            super().__init__()
            self.title = "President"
            self.name = name if name else ""
            self._initialized = True  # to avoid initializing on new calls

    def state_name(self):
        super().state_name()

    @classmethod
    def get_president(cls, name):
        instance = cls(name)
        instance.name = name
        return instance
