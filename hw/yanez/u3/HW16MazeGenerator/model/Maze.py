from model.Room import Room
from model.Direction import Direction
from controller.RandomMazeGenerator import RandomMazeGenerator
from controller.MazePrinter import MazePrinter

class Maze:
    def __init__(self, rows: int, cols: int):
        self.rooms = [[None for _ in range(cols)] for _ in range(rows)]
        self.initialize_rooms()
        self.generate_maze()

    def initialize_rooms(self):
        for row in range(len(self.rooms)):
            for col in range(len(self.rooms[0])):
                self.rooms[row][col] = Room(row, col)

    def generate_maze(self):
        generator = RandomMazeGenerator()
        generator.generate(self.rooms)
        self.rooms[0][0].get_wall(Direction.WEST).open()  # Entrada
        self.rooms[-1][-1].get_wall(Direction.EAST).open()  # Salida

    def display(self):
        printer = MazePrinter(self.rooms)
        printer.print()
