import random
from model.room import Room
from model.door import Door
from model.maze import Maze
from typing import List

class MazeBuilder:
    def generate(self, width: int, height: int) -> Maze:
        rooms: List[List[Room]] = [[Room(x, y) for y in range(height)] for x in range(width)]
        entrance = rooms[0][0]
        exit_room = rooms[width - 1][height - 1]
        self._create_path(entrance, exit_room, rooms, width, height)
        return Maze(rooms, entrance, exit_room)

    def _create_path(self, current: Room, exit_room: Room, rooms: List[List[Room]], width: int, height: int):
        if current == exit_room:
            return

        x, y = current.x, current.y

        if x < width - 1:
            right = rooms[x + 1][y]
            door = Door(current, right)
            current.add_door(door)
            right.add_door(door)
            self._create_path(right, exit_room, rooms, width, height)
        elif y < height - 1:
            down = rooms[x][y + 1]
            door = Door(current, down)
            current.add_door(door)
            down.add_door(door)
            self._create_path(down, exit_room, rooms, width, height)
