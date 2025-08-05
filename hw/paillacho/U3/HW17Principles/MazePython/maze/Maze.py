from controller.MazeGenerator import MazeGenerator
from model.MazeModel import MazeModel
from view.MazeASCIIPrinter import MazeASCIIPrinter
# Author: Carlos Paillacho


def main():
    width = int(input("Enter the width of the maze: "))
    height = int(input("Enter the height of the maze: "))

    generator = MazeGenerator(width, height)
    grid = generator.generate()
    model = MazeModel(grid)
    printer = MazeASCIIPrinter(model)
    printer.print_maze()


if __name__ == "__main__":
    main()
