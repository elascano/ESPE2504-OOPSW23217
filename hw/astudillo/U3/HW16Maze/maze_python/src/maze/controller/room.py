from typing import Dict
from ..model.coordinate import Coordinate
from ..model.wall import Wall


class Room:
    def __init__(self, coordinate: Coordinate):
        self._coordinate = coordinate
        self._walls: Dict[str, Wall] = {
            "UP": Wall(False),
            "DOWN": Wall(False),
            "LEFT": Wall(False),
            "RIGHT": Wall(False)
        }
        self._is_entrance_room = False
        self._is_exit_room = False

    @property
    def coordinate(self) -> Coordinate:
        return self._coordinate

    def open_wall(self, direction: str):
        if direction in self._walls:
            self._walls[direction].open()

    def close_wall(self, direction: str):
        if direction in self._walls:
            self._walls[direction].close()

    def has_door(self, direction: str) -> bool:
        return direction in self._walls and self._walls[direction].is_open

    def has_wall(self, direction: str) -> bool:
        return not self.has_door(direction)

    @property
    def is_entrance(self) -> bool:
        return self._is_entrance_room

    @is_entrance.setter
    def is_entrance(self, value: bool):
        self._is_entrance_room = value

    @property
    def is_exit(self) -> bool:
        return self._is_exit_room

    @is_exit.setter
    def is_exit(self, value: bool):
        self._is_exit_room = value

    @property
    def display_symbol(self) -> str:
        if self.is_entrance:
            return "S"
        elif self.is_exit:
            return "E"
        else:
            return " "

    def __str__(self) -> str:
        return f"Room at {self._coordinate} - {self.display_symbol}"
