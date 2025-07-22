from .room import Room


class Door:
    def __init__(self, first_room: Room, second_room: Room):
        self._first_room = first_room
        self._second_room = second_room

    @property
    def first_room(self) -> Room:
        return self._first_room

    @property
    def second_room(self) -> Room:
        return self._second_room

    def __str__(self) -> str:
        return f"Door connecting {self._first_room.coordinate} and {self._second_room.coordinate}"
