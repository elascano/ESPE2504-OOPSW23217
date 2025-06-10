import json
import os
print("Saving JSON file at:", os.path.abspath("flash_drives.json"))

def load_data():
    if os.path.exists("flash_drives.json"):
        with open("flash_drives.json", "r", encoding="utf-8") as file:
            return json.load(file)
    return []

def save_data(data):
    with open("flash_drives.json", "w", encoding="utf-8") as file:
        json.dump(data, file, indent=4, ensure_ascii=False)

def main():
    print("Registro de memorias USB")

    brand = input("Ingresa la marca de la memoria: ")
    capacity = input("Ingresa la capacidad (GB): ")
    serial = input("Ingresa el número de serie: ")

    new_drive = {
        "brand": brand,
        "capacity_gb": capacity,
        "serial_number": serial
    }

    drives = load_data()
    drives.append(new_drive)
    save_data(drives)

    print("Información de la memoria guardada en 'flash_drives.json'.")

if __name__ == "__main__":
    main()
