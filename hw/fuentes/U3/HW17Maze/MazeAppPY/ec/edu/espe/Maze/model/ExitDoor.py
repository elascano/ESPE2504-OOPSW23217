from model.Door import Door

class ExitDoor(Door):
    def __init__(self, room):
        super().__init__(room, None)

    def get_type(self):
        return "Exit"

    def is_exterior(self):
        return True
