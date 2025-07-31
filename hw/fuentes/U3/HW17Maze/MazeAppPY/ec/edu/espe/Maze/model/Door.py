from abc import ABC, abstractmethod

class Door(ABC):
    def __init__(self, from_room, to_room):
        self.from_room = from_room
        self.to_room = to_room

    @abstractmethod
    def get_type(self):
        pass

    @abstractmethod
    def is_exterior(self):
        pass

    def get_from(self):
        return self.from_room

    def get_to(self):
        return self.to_room
