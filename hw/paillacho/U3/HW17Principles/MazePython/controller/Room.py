class Room:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.walls = {"N": True, "E": True, "S": True, "W": True}

    def remove_wall(self, dx, dy):
        if dx == 1:
            self.walls["E"] = False
        elif dx == -1:
            self.walls["W"] = False
        elif dy == 1:
            self.walls["S"] = False
        elif dy == -1:
            self.walls["N"] = False
