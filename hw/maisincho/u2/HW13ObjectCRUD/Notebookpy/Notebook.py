
from pymongo import MongoClient

connectionString = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=false&w=majority"


def insertarNotebook():
    try:
        id = int(input("Notebook id: "))
        stock = int(input("Stock: "))
        price = float(input("Price: ").replace(',', '.'))
        notebook_type = input("Types of Binding: ").strip()
        desing = input("Design Type: ").strip()
        size = input("Size: ").strip()
        brand = input("Brand: ").strip()

        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]

            existing = collection.find_one({"id": id})
            if existing:
                print(f"Error: Ya existe un notebook con el id {id}")
                return

            document = {
                "id": id,
                "stock": stock,
                "price": price,
                "type": notebook_type,
                "desing": desing,
                "size": size,
                "brand": brand
            }

            collection.insert_one(document)
            print("Registro insertado.")
    except Exception as e:
        print("Error de conexión con MongoDB.", e)

def mostrarNotebook():
    try:
        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]
            print("\nNotebooks:")
            for notebook in collection.find():
                print(notebook)
    except Exception as e:
        print("Error de conexión con MongoDB.", e)

def actualizarNotebook():
    try:
        id = int(input("Id del notebook a actualizar: "))
        stock = int(input("Nuevo stock: "))
        price = float(input("Nuevo price: ").replace(',', '.'))

        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]
            collection.update_one({"id": id},
                                  {"$set": {"stock": stock, "price": price}})

            print("Registro actualizado.")
    except Exception as e:
        print("Error de conexión con MongoDB.", e)

def eliminarNotebook():
    try:
        id = int(input("Id del notebook a eliminar: "))

        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]
            collection.delete_one({"id": id})

            print("Registro eliminado.")
    except Exception as e:
        print("Error de conexión con MongoDB.", e)


def comprarNotebook():
    try:
        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]
            print("\nNotebooks disponibles:")
            for notebook in collection.find():
                print(notebook)

        id = int(input("Ingrese el ID para comprar: ").strip())
        cantidad = int(input("Ingrese la cantidad: ").strip())

        with MongoClient(connectionString) as client:
            db = client["dbmongo"]
            collection = db["notebook"]

            notebook = collection.find_one({"id": id})

            if notebook is None:
                print("Notebook no encontrado.")
                return

            stock = notebook.get("stock", 0)
            price = notebook.get("price", 0.0)

            if cantidad > stock:
                print("Sin stock suficiente.")
                return

            total = price * cantidad

            if total > 20:
                total *= 0.90
                print("10% de descuento.")
            elif total > 5:
                total *= 0.95
                print("5% de descuento.")

            print(f"Has comprado {cantidad} notebook(s).")
            print(f"Valor total de la compra: {total}")

            collection.update_one({"id": id},
                                  {"$inc": {"stock": -cantidad}})
            print("Stock actualizado.")
    except Exception as e:
        print("Error de conexión con MongoDB.", e)

def menuCRUD():
    while True:
        print("\nMenu CRUD:")
        print("1. Agregar notebook")
        print("2. Listar notebook")
        print("3. Actualizar notebook")
        print("4. Eliminar notebook")
        print("0. Volver atrás")

        opcion = int(input("Elige una opción: "))

        if opcion == 1:
            insertarNotebook()
        elif opcion == 2:
            mostrarNotebook()
        elif opcion == 3:
            actualizarNotebook()
        elif opcion == 4:
            eliminarNotebook()
        elif opcion == 0:
            break
        else:
            print("Opción no válida. Intenta nuevamente.")

def menu():
    while True:
        print("\nMenú principal:")
        print("1. Notebooks")
        print("2. Comprar notebook")
        print("0. Salir")

        opcion = int(input("Elige una opción: "))

        if opcion == 1:
            menuCRUD()
        elif opcion == 2:
            comprarNotebook()
        elif opcion == 0:
            print("¡Hasta luego!")
            break
        else:
            print("Opción no válida. Intenta nuevamente.")

if __name__ == "__main__":
    menu()
