from .supervisor import Supervisor

class President(Supervisor):
    _instance = None
    
    def __new__(cls, name=None):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance
    
    def __init__(self, name=None):
        if not hasattr(self, 'initialized'):
            super().__init__(name)
            self.title = "President"
            self.initialized = True
    
    def state_name(self, title=None, name=None):
        if title is None and name is None:
            super().state_name(self.title, self.name)
        else:
            super().state_name(title, name)
    
    @classmethod
    def get_president(cls, name):
        instance = cls(name)
        instance.name = name
        return instance
