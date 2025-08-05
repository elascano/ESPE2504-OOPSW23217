"""
Singleton President class
@author Carlos Paillacho
"""
from model.Supervisor import Supervisor


class President(Supervisor):
    _president = None

    def __new__(cls, name: str = None):
        # Ensure singleton
        if cls._president is None:
            cls._president = super().__new__(cls)
        return cls._president

    def __init__(self, name: str = None):
        # Only set title on first creation
        if not hasattr(self, 'initialized'):
            super().__init__(name)
            self.title = "President"
            self.initialized = True
        # Update name each call
        if name:
            self.name = name

    @classmethod
    def get_president(cls, name: str):
        # Returns singleton instance
        return cls(name)
