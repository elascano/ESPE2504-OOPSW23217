import json
import os

# Función para cargar los datos existentes del archivo JSON
def load_data():
    if os.path.exists("scissors.json"):
        with open("scissors.json", "r", encoding="utf-8") as file:
            return json.load(file)
    return []

# Función para guardar los datos en el archivo JSON
def save_data(data):
    with open("scissors.json", "w", encoding="utf-8") as file:
        json.dump(data, file, indent=4, ensure_ascii=False)

# Función principal que pide los datos al usuario
def add_scissors():
    size = input("Enter the size of the scissors (e.g., small, medium, large): ")
    color = input("Enter the color of the scissors: ")
    orientation = input("Enter the orientation (left or right): ")

    # Creamos un diccionario con los datos ingresados
    scissors = {
        "size": size,
        "color": color,
        "orientation": orientation
    }

    # Cargamos datos existentes del archivo (si los hay)
    existing_data = load_data()

    # Agregamos la nueva tijera a la lista
    existing_data.append(scissors)

    # Guardamos todos los datos en el archivo
    save_data(existing_data)

    # Mostramos el contenido JSON por consola
    print("\nData saved in JSON format:")
    print(json.dumps(existing_data, indent=4, ensure_ascii=False))

# Ejecutamos la función principal
add_scissors()
