from model.Room import Room

class Maze:
    N = 0
    M = 0

    def __init__(self, n, m):
        Maze.N = n
        Maze.M = m
        self.rooms = [[Room(i, j) for j in range(m)] for i in range(n)]
        self.entrance = None
        self.exit = None

    def get_room(self, x, y):
        if 0 <= x < Maze.N and 0 <= y < Maze.M:
            return self.rooms[x][y]
        return None

    def get_rooms(self):
        return self.rooms

    def set_entrance(self, room):
        self.entrance = room

    def get_entrance(self):
        return self.entrance

    def set_exit(self, room):
        self.exit = room

    def get_exit(self):
        return self.exit

    def to_ascii(self):
        result = ""
        for i in range(Maze.N):
            for j in range(Maze.M):
                result += "[ ]"
            result += "\n"
        return result
