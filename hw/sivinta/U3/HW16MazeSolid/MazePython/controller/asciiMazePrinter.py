from controller.mazePrinter import MazePrinter
from model.maze import Maze

class AsciiMazePrinter(MazePrinter):
    def print(self, maze: Maze) -> None:
        rooms = maze.rooms
        width = len(rooms)
        height = len(rooms[0])

        for y in range(height):
            for x in range(width):
                print("+", end="")
                # Check if the door is down
                if any((door.room1.y == y and door.room2.y == y + 1) or (door.room2.y == y and door.room1.y == y + 1) for door in rooms[x][y].doors):
                    print("   ", end="")
                else:
                    print("---", end="")
            print("+")

            for x in range(width):
                # Check if there is a door on the right
                if any((door.room1.x == x and door.room2.x == x + 1) or (door.room2.x == x and door.room1.x == x + 1) for door in rooms[x][y].doors):
                    print(" ", end="")
                else:
                    print("|", end="")
                print("   ", end="")
            print("|")

        for x in range(width):
            print("+---", end="")
        print("+")