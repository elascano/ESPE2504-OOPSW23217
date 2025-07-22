import sys
import os

sys.path.insert(0, os.path.join(os.path.dirname(__file__), 'src'))

from maze.view.system_maze import SystemMaze

if __name__ == "__main__":
    SystemMaze.main()
