from typing import List
from model.room import Room
class Maze:
    def __init__(self, rooms: List[List[Room]], entrance: Room, exit: Room):
        self._rooms = rooms
        self._entrance = entrance
        self._exit = exit

    @property
    def rooms(self) -> List[List[Room]]:
        return self._rooms

    @property
    def entrance(self) -> Room:
        return self._entrance

    @property
    def exit(self) -> Room:
        return self._exit