from abc import ABC, abstractmethod
from typing import List
from model.Room import Room

class MazeGenerator(ABC):
    @abstractmethod
    def generate(self, rooms: List[List[Room]]) -> None:
        pass
