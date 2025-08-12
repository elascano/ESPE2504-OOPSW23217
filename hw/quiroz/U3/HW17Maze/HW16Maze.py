import random
import sys

class Maze:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        self.grid = self.generate_maze()
    
    def generate_maze(self):
        # Initialize maze full of walls (1 = wall, 0 = path)
        maze = [[1 for _ in range(2*self.cols+1)] for _ in range(2*self.rows+1)]
        
        visited = [[False for _ in range(self.cols)] for _ in range(self.rows)]
        start_row = random.randint(0, self.rows-1)
        start_col = random.randint(0, self.cols-1)
        
        stack = [(start_row, start_col)]
        visited[start_row][start_col] = True
        
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # Up, Right, Down, Left
        
        while stack:
            row, col = stack[-1]
            neighbors = []
            
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if (0 <= nr < self.rows and 0 <= nc < self.cols and 
                    not visited[nr][nc]):
                    neighbors.append((dr, dc, nr, nc))
            
            if neighbors:
                dr, dc, nr, nc = random.choice(neighbors)
                maze[2*row+1 + dr][2*col+1 + dc] = 0
                visited[nr][nc] = True
                stack.append((nr, nc))
            else:
                stack.pop()
        
        # Set entrance and exit
        maze[1][0] = 0  # Entrance (left side)
        maze[-2][-1] = 0  # Exit (right side)
        
        return maze
    
    def print_ascii(self):
        # Use standard ASCII characters for better compatibility
        wall = '#'
        path = ' '
        entrance = 'E'
        exit_char = 'X'
        
        # Mark entrance and exit
        display_grid = [row.copy() for row in self.grid]
        display_grid[1][0] = 2  # Entrance
        display_grid[-2][-1] = 3  # Exit
        
        for row in display_grid:
            line = []
            for cell in row:
                if cell == 1:
                    line.append(wall)
                elif cell == 2:
                    line.append(entrance)
                elif cell == 3:
                    line.append(exit_char)
                else:
                    line.append(path)
            print(''.join(line))

def main():
    print("ASCII Maze Generator")
    print("-------------------")
    
    try:
        rows = int(input("Enter number of rows (N, minimum 2): "))
        cols = int(input("Enter number of columns (M, minimum 2): "))
        
        if rows < 2 or cols < 2:
            print("Error: Maze must be at least 2x2")
            sys.exit(1)
            
        maze = Maze(rows, cols)
        print("\nGenerated Maze:")
        maze.print_ascii()
        
        print("\nLegend:")
        print("# = Wall")
        print("E = Entrance")
        print("X = Exit")
    
    except ValueError:
        print("Error: Please enter valid integers")
        sys.exit(1)
    except KeyboardInterrupt:
        print("\nOperation cancelled by user")
        sys.exit(0)

if __name__ == "__main__":
    main()