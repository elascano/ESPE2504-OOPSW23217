from .door import Door
from .room import Room


class EndDoor(Door):
    def __init__(self, exit_room: Room):
        super().__init__(exit_room, exit_room)

    def __str__(self) -> str:
        return f"End Door at {self.first_room.coordinate}"
