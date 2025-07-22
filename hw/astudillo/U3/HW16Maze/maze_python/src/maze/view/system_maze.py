from ..controller.setting_maze import DefaultMazeSetting


class SystemMaze:
    @staticmethod
    def main():
        try:
            print("=== Generador de Laberintos ===")
            number_of_columns = int(input("Ingrese el número de columnas del laberinto: "))
            number_of_rows = int(input("Ingrese el número de filas del laberinto: "))
            
            if number_of_rows <= 0 or number_of_columns <= 0:
                print("Error: Las dimensiones deben ser números positivos.")
                return
            
            maze_setting = DefaultMazeSetting(number_of_rows, number_of_columns)
            
            print("Generando laberinto...")
            maze = maze_setting.generate_maze()
            
            print("\nLaberinto generado:")
            print("S = Entrada (Start), E = Salida (Exit)")
            print()
            maze.display()
            
        except ValueError:
            print("Error: Por favor ingrese números válidos.")
        except KeyboardInterrupt:
            print("\nPrograma interrumpido por el usuario.")
        except Exception as e:
            print(f"Error inesperado: {e}")


if __name__ == "__main__":
    SystemMaze.main()
