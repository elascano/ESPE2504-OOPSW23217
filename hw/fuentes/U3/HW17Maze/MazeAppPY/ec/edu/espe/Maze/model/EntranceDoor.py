from model.Door import Door

class EntranceDoor(Door):
    def __init__(self, room):
        super().__init__(None, room)

    def get_type(self):
        return "Entrance"

    def is_exterior(self):
        return True
