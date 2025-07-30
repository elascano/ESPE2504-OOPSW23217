from model.mazeBuilder import MazeBuilder
from controller.asciiMazePrinter import AsciiMazePrinter

def main():
    width = 5
    height = 5

    generator = MazeBuilder()
    maze = generator.generate(width, height)

    printer = AsciiMazePrinter()
    printer.print(maze)

if __name__ == "__main__":
    main()