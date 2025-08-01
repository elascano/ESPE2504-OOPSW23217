import random
from model.Maze import Maze
from model.Wall import Wall
from model.EntranceDoor import EntranceDoor
from model.ExitDoor import ExitDoor
from model.InnerDoor import InnerDoor

class MazeGenerator:
    def generate_maze(self, n, m):
        maze = Maze(n, m)
        self.add_default_walls(maze)

        visited = set()
        stack = []

        start = maze.get_room(0, 0)
        end = maze.get_room(n - 1, m - 1)

        maze.set_entrance(start)
        maze.set_exit(end)

        visited.add((start.get_x(), start.get_y()))
        stack.append(start)

        while stack:
            current = stack[-1]
            neighbors = self.get_unvisited_neighbors(maze, current, visited)

            if neighbors:
                next_room = random.choice(neighbors)
                self.remove_wall_between(current, next_room)
                self.create_inner_door(current, next_room)
                visited.add((next_room.get_x(), next_room.get_y()))
                stack.append(next_room)
            else:
                stack.pop()

        start.set_door(EntranceDoor(start))
        end.set_door(ExitDoor(end))

        return maze

    def add_default_walls(self, maze):
        for i in range(maze.N):
            for j in range(maze.M):
                room = maze.get_room(i, j)
                room.get_walls().clear()
                room.add_wall(Wall('N', True))
                room.add_wall(Wall('S', True))
                room.add_wall(Wall('E', True))
                room.add_wall(Wall('W', True))

    def remove_wall_between(self, a, b):
        dx = b.get_x() - a.get_x()
        dy = b.get_y() - a.get_y()
        if dx == 1:
            self.remove_wall(a, 'S')
            self.remove_wall(b, 'N')
        elif dx == -1:
            self.remove_wall(a, 'N')
            self.remove_wall(b, 'S')
        elif dy == 1:
            self.remove_wall(a, 'E')
            self.remove_wall(b, 'W')
        elif dy == -1:
            self.remove_wall(a, 'W')
            self.remove_wall(b, 'E')

    def remove_wall(self, room, direction):
        room.walls = [w for w in room.get_walls() if w.get_direction() != direction]

    def get_unvisited_neighbors(self, maze, room, visited):
        neighbors = []
        x, y = room.get_x(), room.get_y()

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            neighbor = maze.get_room(nx, ny)
            if neighbor and (nx, ny) not in visited:
                neighbors.append(neighbor)

        return neighbors

    def create_inner_door(self, from_room, to_room):
        from_room.set_door(InnerDoor(from_room, to_room))
        to_room.set_door(InnerDoor(to_room, from_room))
