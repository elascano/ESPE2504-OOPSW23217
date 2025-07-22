class Coordinate:
    def __init__(self, row: int, column: int):
        self._row = row
        self._column = column

    @property
    def row(self) -> int:
        return self._row

    @property
    def column(self) -> int:
        return self._column

    def __str__(self) -> str:
        return f"({self._row}, {self._column})"

    def __eq__(self, other) -> bool:
        if not isinstance(other, Coordinate):
            return False
        return self._row == other._row and self._column == other._column

    def __hash__(self) -> int:
        return hash((self._row, self._column))
