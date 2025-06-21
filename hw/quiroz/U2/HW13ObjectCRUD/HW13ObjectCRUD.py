from pymongo import MongoClient
from statistics import mean

# Conexión MongoDB Atlas
client = MongoClient("mongodb+srv://mlquiroz:Mlqh2006@cluster0.vpeg1ly.mongodb.net/")
db = client["goalkeeper_db"]
collection = db["goalkeepers"]

class Goalkeeper:
    def __init__(self, id, name, age, saves):
        self.id = id
        self.name = name
        self.age = age
        self.saves = saves

    def to_dict(self):
        return {"id": self.id, "name": self.name, "age": self.age, "saves": self.saves}

def create_goalkeeper():
    id = int(input("ID: "))
    name = input("Name: ")
    age = int(input("Age: "))
    saves = int(input("Saves: "))
    gk = Goalkeeper(id, name, age, saves)
    collection.insert_one(gk.to_dict())
    print(" Added to MongoDB")

def read_goalkeepers():
    print("=== Goalkeepers ===")
    for doc in collection.find():
        print(doc)

def update_goalkeeper():
    id = int(input("ID of goalkeeper to update: "))
    saves = int(input("New number of saves: "))
    result = collection.update_one({"id": id}, {"$set": {"saves": saves}})
    if result.matched_count:
        print("Updated")
    else:
        print("Not found")

def delete_goalkeeper():
    id = int(input("ID of goalkeeper to delete: "))
    result = collection.delete_one({"id": id})
    if result.deleted_count:
        print("Deleted")
    else:
        print("Not found")

def calculate_average_saves():
    saves_list = [doc["saves"] for doc in collection.find()]
    if saves_list:
        avg = mean(saves_list)
        print(f" Average Saves: {avg:.2f}")
    else:
        print(" No data")

def menu():
    while True:
        print("\n1. Create a new goalkeeper\n2. Read goalkeeper information\n3. Update goalkeeper saves\n4. Delete goalkeeper information\n5. Average Saves\n6. Exit")
        choice = input("Option: ")
        if choice == '1':
            create_goalkeeper()
        elif choice == '2':
            read_goalkeepers()
        elif choice == '3':
            update_goalkeeper()
        elif choice == '4':
            delete_goalkeeper()
        elif choice == '5':
            calculate_average_saves()
        elif choice == '6':
            break
        else:
            print(" Invalid option")

if __name__ == "__main__":
    menu()
