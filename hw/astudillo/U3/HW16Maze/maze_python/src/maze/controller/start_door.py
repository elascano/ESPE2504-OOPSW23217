from .door import Door
from .room import Room


class StartDoor(Door):
    def __init__(self, entrance_room: Room):
        super().__init__(entrance_room, entrance_room)

    def __str__(self) -> str:
        return f"Start Door at {self.first_room.coordinate}"
