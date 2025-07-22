import sys
import os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'src'))

from maze.model.coordinate import Coordinate
from maze.model.wall import Wall
from maze.controller.room import Room
from maze.controller.maze import Maze
from maze.controller.setting_maze import DefaultMazeSetting


def test_coordinate():
    coord = Coordinate(1, 2)
    assert coord.row == 1
    assert coord.column == 2
    print("✓ Coordinate test passed")


def test_wall():
    wall = Wall(False)
    assert not wall.is_open
    wall.open()
    assert wall.is_open
    wall.close()
    assert not wall.is_open
    print("✓ Wall test passed")


def test_room():
    coord = Coordinate(0, 0)
    room = Room(coord)
    assert room.coordinate == coord
    assert not room.has_door("UP")
    room.open_wall("UP")
    assert room.has_door("UP")
    print("✓ Room test passed")


def test_maze():
    maze = Maze(3, 3)
    assert maze.number_of_rows == 3
    assert maze.number_of_columns == 3
    assert len(maze.rooms) == 3
    assert len(maze.rooms[0]) == 3
    print("✓ Maze test passed")


def test_maze_generation():
    setting = DefaultMazeSetting(5, 5)
    maze = setting.generate_maze()
    assert maze.entrance_room is not None
    assert maze.exit_room is not None
    assert maze.entrance_room.is_entrance
    assert maze.exit_room.is_exit
    print("✓ Maze generation test passed")


def run_all_tests():
    print("Running tests...")
    try:
        test_coordinate()
        test_wall()
        test_room()
        test_maze()
        test_maze_generation()
        print("\n🎉 All tests passed!")
    except Exception as e:
        print(f"\n❌ Test failed: {e}")


if __name__ == "__main__":
    run_all_tests()
