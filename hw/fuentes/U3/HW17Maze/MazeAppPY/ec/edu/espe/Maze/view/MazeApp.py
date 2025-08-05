import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from controller.MazeGenerator import MazeGenerator
from view.MazePrinter import print_maze_ascii

def main():
    print("=== Maze Generator ===")
    N = int(input("Enter number of rows (N): "))
    M = int(input("Enter number of columns (M): "))

    generator = MazeGenerator()
    maze = generator.generate_maze(N, M)

    print("\nGenerated Maze:\n")
    print_maze_ascii(maze)

if __name__ == "__main__":
    main()
