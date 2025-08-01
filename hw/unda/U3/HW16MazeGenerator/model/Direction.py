from enum import Enum

class Direction(Enum):
    NORTH = (-1, 0)
    SOUTH = (1, 0)
    EAST = (0, 1)
    WEST = (0, -1)

    def __init__(self, row_offset, col_offset):
        self._row_offset = row_offset
        self._col_offset = col_offset

    @property
    def row_offset(self):
        return self._row_offset

    @property
    def col_offset(self):
        return self._col_offset

    @staticmethod
    def opposite(direction):
        opposites = {
            Direction.NORTH: Direction.SOUTH,
            Direction.SOUTH: Direction.NORTH,
            Direction.EAST: Direction.WEST,
            Direction.WEST: Direction.EAST
        }
        return opposites[direction]
