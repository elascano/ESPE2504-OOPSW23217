from abc import ABC, abstractmethod
from model.maze import Maze

class MazePrinter(ABC):
    @abstractmethod
    def print(self, maze: Maze) -> None:
        pass