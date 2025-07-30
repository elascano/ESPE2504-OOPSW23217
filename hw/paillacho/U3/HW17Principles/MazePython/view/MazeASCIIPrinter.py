class MazeASCIIPrinter:
    def __init__(self, model):
        self.model = model

    def print_maze(self):
        grid = self.model.get_grid()
        for row in grid:
            print("".join(row))
