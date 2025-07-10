from pymongo import MongoClient
from bson.objectid import ObjectId

# Conexión a MongoDB
client = MongoClient("mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
db = client["ScissorsDB"]
collection = db["scissors"]

def create_scissor():
    name = input("Nombre de la tijera: ")
    brand = input("Marca: ")
    price = float(input("Precio: "))
    data = {"name": name, "brand": brand, "price": price}
    collection.insert_one(data)
    print("Tijera agregada con éxito.\n")

def read_scissors():
    print("📋 Lista de tijeras registradas:")
    for scissor in collection.find():
        print(f"- ID: {scissor['_id']}, Nombre: {scissor['name']}, Marca: {scissor['brand']}, Precio: {scissor['price']}")
    print()

def update_scissor():
    scissor_id = input("ID de la tijera a actualizar: ")
    name = input("Nuevo nombre: ")
    brand = input("Nueva marca: ")
    price = float(input("Nuevo precio: "))
    result = collection.update_one(
        {"_id": ObjectId(scissor_id)},
        {"$set": {"name": name, "brand": brand, "price": price}}
    )
    if result.modified_count:
        print("Tijera actualizada.\n")
    else:
        print("No se encontró la tijera o no hubo cambios.\n")

def delete_scissor():
    scissor_id = input("ID de la tijera a eliminar: ")
    result = collection.delete_one({"_id": ObjectId(scissor_id)})
    if result.deleted_count:
        print("Tijera eliminada.\n")
    else:
        print("No se encontró la tijera.\n")

def main():
    while True:
        print("=== MENÚ CRUD Tijeras ===")
        print("1. Agregar tijera")
        print("2. Ver tijeras")
        print("3. Actualizar tijera")
        print("4. Eliminar tijera")
        print("5. Salir")
        option = input("Elige una opción (1-5): ")

        if option == "1":
            create_scissor()
        elif option == "2":
            read_scissors()
        elif option == "3":
            update_scissor()
        elif option == "4":
            delete_scissor()
        elif option == "5":
            print("Saliendo del programa.")
            break
        else:
            print("Opción no válida.\n")

main()
