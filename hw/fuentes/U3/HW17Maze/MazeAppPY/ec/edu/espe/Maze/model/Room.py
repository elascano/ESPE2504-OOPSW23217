from model.Wall import Wall

class Room:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.walls = []
        self.door = None

    def has_wall(self, direction):
        return any(w.get_direction() == direction and w.exists_wall() for w in self.walls)

    def has_door(self):
        return self.door is not None

    def is_corner(self, n, m):
        return (self.x == 0 or self.x == n - 1) and (self.y == 0 or self.y == m - 1)

    def set_door(self, door):
        self.door = door

    def get_walls(self):
        return self.walls

    def get_door(self):
        return self.door

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def add_wall(self, wall):
        if len(self.walls) < 4:
            self.walls.append(wall)
