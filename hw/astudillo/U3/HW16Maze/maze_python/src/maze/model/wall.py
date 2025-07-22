class Wall:
    def __init__(self, is_open: bool = False):
        self._is_open = is_open

    @property
    def is_open(self) -> bool:
        return self._is_open

    @is_open.setter
    def is_open(self, value: bool):
        self._is_open = value

    def open(self):
        self._is_open = True

    def close(self):
        self._is_open = False

    def __str__(self) -> str:
        return "Open" if self._is_open else "Closed"
