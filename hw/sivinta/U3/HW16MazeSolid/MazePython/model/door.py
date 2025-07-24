from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from model.room import Room  

class Door:
    def __init__(self, room1: 'Room', room2: 'Room'):
        self._room1 = room1
        self._room2 = room2

    @property
    def room1(self) -> 'Room':
        return self._room1

    @property
    def room2(self) -> 'Room':
        return self._room2