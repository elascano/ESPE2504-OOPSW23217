
from typing import List
from model.door import Door

class Room:
    def __init__(self, x: int, y: int):
        self._x = x
        self._y = y
        self._doors: List[Door] = []

    @property
    def x(self) -> int:
        return self._x

    @property
    def y(self) -> int:
        return self._y

    @property
    def doors(self) -> List[Door]:
        return self._doors

    def add_door(self, door: Door) -> None:
        self._doors.append(door)