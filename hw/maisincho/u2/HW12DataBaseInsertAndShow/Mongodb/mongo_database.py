from pymongo import MongoClient
import json


connection_string = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

def insertar_laptop():
    try:
        id_laptop = input("Laptop ID: ")
        name = input("Name Laptop: ")
        processor = input("Processor: ")
        ram = int(input("Enter the RAM (GB): "))
        color = input("Enter color of the laptop: ")

        document = {
            "id": id_laptop,
            "name": name,
            "processor": processor,
            "ram": ram,
            "color": color
        }

        with MongoClient(connection_string) as client:
            db = client["dbmongo"]
            collection = db["laptop"]
            collection.insert_one(document)
            print(" Laptop inserted successfully.")

    except Exception as e:
        print(f" Error connecting or inserting to MongoDB: {e}")

def mostrar_laptops():
    try:
        with MongoClient(connection_string) as client:
            db = client["dbmongo"]
            collection = db["laptop"]
            print("\n Laptops in the database:")
            for doc in collection.find():
                print(json.dumps(doc, indent=4, default=str))

    except Exception as e:
        print(f" Error retrieving data from MongoDB: {e}")

def menu():
    while True:
        print("\n  MENU:")
        print("1. Insert Laptop")
        print("2. Show Laptops")
        print("0. Exit")

        opcion = input("Select an option: ")

        if opcion == '1':
            insertar_laptop()
        elif opcion == '2':
            mostrar_laptops()
        elif opcion == '0':
            print(" Exiting program...")
            break
        else:
            print("  Invalid option, try again.")

if __name__ == "__main__":
    menu()
