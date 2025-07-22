from typing import List, Optional
from ..model.coordinate import Coordinate
from .room import Room


class Maze:
    def __init__(self, number_of_rows: int, number_of_columns: int):
        self._number_of_rows = number_of_rows
        self._number_of_columns = number_of_columns
        self._rooms: List[List[Room]] = []
        self._entrance_room: Optional[Room] = None
        self._exit_room: Optional[Room] = None
        
        for row in range(number_of_rows):
            room_row = []
            for column in range(number_of_columns):
                coordinate = Coordinate(row, column)
                room_row.append(Room(coordinate))
            self._rooms.append(room_row)

    @property
    def rooms(self) -> List[List[Room]]:
        return self._rooms

    @property
    def number_of_rows(self) -> int:
        return self._number_of_rows

    @property
    def number_of_columns(self) -> int:
        return self._number_of_columns

    def set_entrance(self, entrance_room: Room):
        self._entrance_room = entrance_room
        if entrance_room:
            entrance_room.is_entrance = True

    def set_exit(self, exit_room: Room):
        self._exit_room = exit_room
        if exit_room:
            exit_room.is_exit = True

    @property
    def entrance_room(self) -> Optional[Room]:
        return self._entrance_room

    @property
    def exit_room(self) -> Optional[Room]:
        return self._exit_room

    def display(self):
        for column in range(self._number_of_columns):
            print("+", end="")
            if self._rooms[0][column].has_door("UP"):
                print(" ", end="")
            else:
                print("-", end="")
        print("+")

        for row in range(self._number_of_rows):
            for column in range(self._number_of_columns):
                if self._rooms[row][column].has_door("LEFT"):
                    print(" ", end="")
                else:
                    print("|", end="")
                print(self._rooms[row][column].display_symbol, end="")
            print("|")

            for column in range(self._number_of_columns):
                print("+", end="")
                if self._rooms[row][column].has_door("DOWN"):
                    print(" ", end="")
                else:
                    print("-", end="")
            print("+")

    def get_room(self, row: int, column: int) -> Optional[Room]:
        if 0 <= row < self._number_of_rows and 0 <= column < self._number_of_columns:
            return self._rooms[row][column]
        return None

    def __str__(self) -> str:
        return f"Maze {self._number_of_rows}x{self._number_of_columns}"
