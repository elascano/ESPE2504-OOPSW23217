import random


class MazeGenerator:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.grid = [['#' for _ in range(width * 2 + 1)]
                     for _ in range(height * 2 + 1)]

    def generate(self):
        visited = [[False for _ in range(self.width)]
                   for _ in range(self.height)]

        def dfs(x, y):
            directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]
            random.shuffle(directions)
            visited[y][x] = True
            self.grid[y * 2 + 1][x * 2 + 1] = ' '

            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < self.width and 0 <= ny < self.height and not visited[ny][nx]:
                    self.grid[y * 2 + 1 + dy][x * 2 + 1 + dx] = ' '
                    dfs(nx, ny)

        dfs(0, 0)
        self.grid[1][0] = 'S'  # Start
        self.grid[self.height * 2 - 1][self.width * 2] = 'E'  # End
        return self.grid
