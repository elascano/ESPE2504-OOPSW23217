from random import shuffle
from controller.Direction import directions


class DFSMazeGenerator:
    def generate(self, grid, width, height):
        visited = [[False for _ in range(height)] for _ in range(width)]
        self._dfs(grid, visited, 0, 0, width, height)

    def _dfs(self, grid, visited, x, y, width, height):
        visited[x][y] = True
        dirs = directions()
        shuffle(dirs)

        for dx, dy in dirs:
            nx, ny = x + dx, y + dy
            if 0 <= nx < width and 0 <= ny < height and not visited[nx][ny]:
                grid[x][y].remove_wall(dx, dy)
                grid[nx][ny].remove_wall(-dx, -dy)
                self._dfs(grid, visited, nx, ny, width, height)
