from model.Maze import Maze

def main():
    try:
        rows = int(input("Ingrese el numero de filas del laberinto: "))
        cols = int(input("Ingrese el numero de columnas del laberinto: "))

        if rows < 1 or cols < 1:
            print("Dimensiones invalidas. Deben ser mayores a 0.")
            return

        maze = Maze(rows, cols)
        maze.display()

    except ValueError:
        print("Por favor, ingrese números enteros válidos.")

if __name__ == "__main__":
    main()
