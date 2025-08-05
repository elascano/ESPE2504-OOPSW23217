class Wall:
    def __init__(self):
        self.is_open = False

    def open(self):
        self.is_open = True

    def is_opened(self) -> bool:
        return self.is_open
