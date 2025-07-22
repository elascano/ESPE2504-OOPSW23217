from abc import ABC, abstractmethod
import random
from typing import List
from .maze import Maze
from .room import Room


class SettingMaze(ABC):
    def __init__(self, number_of_rows: int, number_of_columns: int):
        self._number_of_rows = number_of_rows
        self._number_of_columns = number_of_columns

    @property
    def number_of_rows(self) -> int:
        return self._number_of_rows

    @property
    def number_of_columns(self) -> int:
        return self._number_of_columns

    def generate_maze(self) -> Maze:
        maze = Maze(self._number_of_rows, self._number_of_columns)
        rooms = maze.rooms
        visited_rooms = [[False for _ in range(self._number_of_columns)] 
                        for _ in range(self._number_of_rows)]

        entrance_row = 0
        entrance_column = random.randint(0, self._number_of_columns - 1)
        exit_row = self._number_of_rows - 1
        exit_column = random.randint(0, self._number_of_columns - 1)

        entrance_room = rooms[entrance_row][entrance_column]
        exit_room = rooms[exit_row][exit_column]
        
        maze.set_entrance(entrance_room)
        maze.set_exit(exit_room)

        self._generate_maze_depth_first_search(entrance_room, visited_rooms, rooms)

        self._close_outer_walls(rooms)
        
        entrance_room.open_wall("UP")
        exit_room.open_wall("DOWN")

        return maze

    def _generate_maze_depth_first_search(self, current_room: Room, 
                                        visited_rooms: List[List[bool]], 
                                        rooms: List[List[Room]]):
        current_row = current_room.coordinate.row
        current_column = current_room.coordinate.column
        visited_rooms[current_row][current_column] = True

        directions = ["UP", "DOWN", "LEFT", "RIGHT"]
        random.shuffle(directions)

        for direction in directions:
            next_row, next_column = self._get_next_position(current_row, current_column, direction)
            
            if (self._is_valid_position(next_row, next_column) and 
                not visited_rooms[next_row][next_column]):
                
                current_room.open_wall(direction)
                rooms[next_row][next_column].open_wall(self._get_opposite_direction(direction))
                self._generate_maze_depth_first_search(rooms[next_row][next_column], 
                                                     visited_rooms, rooms)

    def _get_next_position(self, row: int, column: int, direction: str) -> tuple:
        if direction == "UP":
            return row - 1, column
        elif direction == "DOWN":
            return row + 1, column
        elif direction == "LEFT":
            return row, column - 1
        elif direction == "RIGHT":
            return row, column + 1
        return row, column

    def _is_valid_position(self, row: int, column: int) -> bool:
        return (0 <= row < self._number_of_rows and 
                0 <= column < self._number_of_columns)

    def _get_opposite_direction(self, direction: str) -> str:
        opposite_directions = {
            "UP": "DOWN",
            "DOWN": "UP",
            "LEFT": "RIGHT",
            "RIGHT": "LEFT"
        }
        return opposite_directions.get(direction, direction)

    def _close_outer_walls(self, rooms: List[List[Room]]):
        for column in range(self._number_of_columns):
            rooms[0][column].close_wall("UP")
            rooms[self._number_of_rows - 1][column].close_wall("DOWN")

        for row in range(self._number_of_rows):
            rooms[row][0].close_wall("LEFT")
            rooms[row][self._number_of_columns - 1].close_wall("RIGHT")


class DefaultMazeSetting(SettingMaze):
    pass
