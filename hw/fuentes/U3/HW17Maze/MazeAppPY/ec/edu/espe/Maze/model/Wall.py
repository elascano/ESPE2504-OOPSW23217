from dataclasses import dataclass

@dataclass
class Wall:
    direction: str
    exists: bool

    def get_direction(self):
        return self.direction

    def exists_wall(self):
        return self.exists
