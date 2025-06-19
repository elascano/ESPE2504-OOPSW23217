from pymongo import MongoClient
import json

# Constantes de configuración
CONNECTION_STRING = "mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/"
DATABASE_NAME = "WarGame"
COLLECTION_NAME = "Scissors"
OUTPUT_FILE = "scissors.json"

def read_scissor_data():
    try:
        id = int(input("ID: "))
        handedness = input("Handedness (right-handed / left-handed): ")
        color = input("Color: ")
        length = float(input("Length (cm): "))
        price = float(input("Price: "))

        return {
            "id": id,
            "handedness": handedness,
            "color": color,
            "length": length,
            "price": price
        }
    except ValueError as e:
        print("Invalid input:", e)
        return None

def save_json_to_file(data, filename):
    try:
        with open(filename, "w") as f:
            json.dump(data, f, indent=4)
        print(f"JSON saved to {filename}")
    except Exception as e:
        print("Error saving JSON:", e)

def insert_to_mongodb(document):
    try:
        client = MongoClient(CONNECTION_STRING)
        db = client[DATABASE_NAME]
        collection = db[COLLECTION_NAME]
        collection.insert_one(document)
        print("Scissor data inserted into MongoDB.")
    except Exception as e:
        print("Database error:", e)
    finally:
        client.close()

if __name__ == "__main__":
    scissor_data = read_scissor_data()
    if scissor_data:
        save_json_to_file(scissor_data, OUTPUT_FILE)
        insert_to_mongodb(scissor_data)
