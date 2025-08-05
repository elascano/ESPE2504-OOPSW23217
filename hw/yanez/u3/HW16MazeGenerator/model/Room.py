from model.Direction import Direction
from model.Wall import Wall

class Room:
    def __init__(self, row: int, col: int):
        self.row = row
        self.col = col
        self.visited = False
        self.walls = {direction: Wall() for direction in Direction}

    def get_wall(self, direction: Direction) -> Wall:
        return self.walls[direction]

    def set_wall(self, direction: Direction, wall: Wall):
        self.walls[direction] = wall

    def is_visited(self) -> bool:
        return self.visited

    def set_visited(self, visited: bool):
        self.visited = visited

    def get_row(self) -> int:
        return self.row

    def get_col(self) -> int:
        return self.col
