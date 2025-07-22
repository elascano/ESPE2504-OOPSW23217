from typing import List
from .room import Room


class Path:
    def __init__(self):
        self._rooms_in_path: List[Room] = []

    def add_room(self, room: Room):
        self._rooms_in_path.append(room)

    def remove_room(self, room: Room):
        if room in self._rooms_in_path:
            self._rooms_in_path.remove(room)

    @property
    def rooms(self) -> List[Room]:
        return self._rooms_in_path.copy()

    @property
    def length(self) -> int:
        return len(self._rooms_in_path)

    def clear(self):
        self._rooms_in_path.clear()

    def contains_room(self, room: Room) -> bool:
        return room in self._rooms_in_path

    def __str__(self) -> str:
        if not self._rooms_in_path:
            return "Empty path"
        coordinates = [str(room.coordinate) for room in self._rooms_in_path]
        return f"Path: {' -> '.join(coordinates)}"
