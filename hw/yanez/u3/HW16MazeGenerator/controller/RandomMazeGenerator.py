import random
from typing import List, Optional
from model.Direction import Direction
from model.Room import Room
from controller.MazeGenerator import MazeGenerator

class RandomMazeGenerator(MazeGenerator):
    def generate(self, rooms: List[List[Room]]) -> None:
        stack = []
        start = rooms[0][0]
        start.set_visited(True)
        stack.append(start)

        while stack:
            current = stack[-1]
            unvisited_neighbors = self.get_unvisited_neighbors(current, rooms)

            if unvisited_neighbors:
                dir = random.choice(unvisited_neighbors)
                neighbor = self.get_neighbor(current, dir, rooms)

                current.get_wall(dir).open()
                neighbor.get_wall(Direction.opposite(dir)).open()

                neighbor.set_visited(True)
                stack.append(neighbor)
            else:
                stack.pop()

    def get_unvisited_neighbors(self, room: Room, rooms: List[List[Room]]) -> List[Direction]:
        neighbors = []
        for dir in Direction:
            neighbor = self.get_neighbor(room, dir, rooms)
            if neighbor is not None and not neighbor.is_visited():
                neighbors.append(dir)
        return neighbors

    def get_neighbor(self, room: Room, dir: Direction, rooms: List[List[Room]]) -> Optional[Room]:
        new_row = room.get_row() + dir.row_offset
        new_col = room.get_col() + dir.col_offset

        if 0 <= new_row < len(rooms) and 0 <= new_col < len(rooms[0]):
            return rooms[new_row][new_col]
        return None
