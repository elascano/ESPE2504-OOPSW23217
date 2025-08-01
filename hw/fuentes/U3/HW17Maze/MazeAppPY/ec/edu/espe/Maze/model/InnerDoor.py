from model.Door import Door

class InnerDoor(Door):
    def __init__(self, from_room, to_room):
        super().__init__(from_room, to_room)

    def get_type(self):
        return "Inner"

    def is_exterior(self):
        return False
