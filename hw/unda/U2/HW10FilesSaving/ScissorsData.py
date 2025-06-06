import json
import os

def load_data():
    if os.path.exists("scissors.json"):
        with open("scissors.json", "r", encoding="utf-8") as file:
            return json.load(file)
    return []

# Guardar los datos en el archivo JSON
def save_data(data):
    with open("scissors.json", "w", encoding="utf-8") as file:
        json.dump(data, file, indent=4, ensure_ascii=False)

def add_scissors():
    size = input("Enter the size of the scissors (small, medium, large): ")
    color = input("Enter the color of the scissors: ")
    orientation = input("Enter the orientation (left or right): ")

    scissors = {
        "size": size,
        "color": color,
        "orientation": orientation
    }

    # Cargamos datos existentes del archivo
    existing_data = load_data()

    existing_data.append(scissors)

    save_data(existing_data)

    # Mostramos el contenido JSON por consola
    print("\nData saved in JSON format:")
    print(json.dumps(existing_data, indent=4, ensure_ascii=False))

# Ejecutamos la función principal
add_scissors()