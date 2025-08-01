from model.Direction import Direction
from model.Room import Room
from typing import List

class MazePrinter:
    def __init__(self, rooms: List[List[Room]]):
        self.rooms = rooms

    def print(self):
        rows = len(self.rooms)
        cols = len(self.rooms[0])

        for row in range(rows):
            # Parte superior de cada celda (techo)
            for col in range(cols):
                print("+", end="")
                print("   " if self.rooms[row][col].get_wall(Direction.NORTH).is_opened() else "---", end="")
            print("+")

            # Parte central: paredes laterales y contenido
            for col in range(cols):
                if row == 0 and col == 0:
                    print("E", end="")  # entrada
                else:
                    print(" " if self.rooms[row][col].get_wall(Direction.WEST).is_opened() else "|", end="")

                print("   ", end="")

                if row == rows - 1 and col == cols - 1:
                    print("S", end="")  # salida
                elif col == cols - 1:
                    print(" " if self.rooms[row][col].get_wall(Direction.EAST).is_opened() else "|", end="")
            print()

        # Parte inferior final (Sur)
        for col in range(cols):
            print("+---", end="")
        print("+")
