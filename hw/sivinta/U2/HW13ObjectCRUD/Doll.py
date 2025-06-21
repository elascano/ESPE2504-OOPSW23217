import json
import uuid

try:
    from pymongo import MongoClient
    pymongo_disponible = True
except ImportError:
    pymongo_disponible = False
    print("Advertencia: pymongo no está instalado. La función de subida a MongoDB no estará disponible.")

# Configura tu conexión a MongoDB Atlas
MONGO_URI = "mongodb+srv://<usuario>:<contraseña>@<cluster>.mongodb.net/?retryWrites=true&w=majority"
DB_NAME = "tienda"
COLLECTION_NAME = "muñecas"

# Archivo local para guardar los datos temporalmente
FILE_NAME = "muñecas.json"

# Cálculo del IVA (suponiendo 12%)
def calcular_iva(precio):
    return round(precio * 0.12, 2)

def cargar_datos():
    try:
        with open(FILE_NAME, "r") as file:
            return json.load(file)
    except FileNotFoundError:
        return []

def guardar_datos(datos):
    with open(FILE_NAME, "w") as file:
        json.dump(datos, file, indent=4)

def crear_muñeca(nombre, precio):
    datos = cargar_datos()
    muñeca = {
        "id": str(uuid.uuid4()),
        "nombre": nombre,
        "precio": precio,
        "iva": calcular_iva(precio),
        "precio_total": round(precio + calcular_iva(precio), 2)
    }
    datos.append(muñeca)
    guardar_datos(datos)
    print("Muñeca creada con éxito.")

def leer_muñecas():
    datos = cargar_datos()
    for muñeca in datos:
        print(muñeca)

def actualizar_muñeca(id_objetivo, nuevo_nombre, nuevo_precio):
    datos = cargar_datos()
    for muñeca in datos:
        if muñeca["id"] == id_objetivo:
            muñeca["nombre"] = nuevo_nombre
            muñeca["precio"] = nuevo_precio
            muñeca["iva"] = calcular_iva(nuevo_precio)
            muñeca["precio_total"] = round(nuevo_precio + muñeca["iva"], 2)
            guardar_datos(datos)
            print("Muñeca actualizada.")
            return
    print("Muñeca no encontrada.")

def eliminar_muñeca(id_objetivo):
    datos = cargar_datos()
    datos_filtrados = [m for m in datos if m["id"] != id_objetivo]
    guardar_datos(datos_filtrados)
    print("Muñeca eliminada si existía.")

def subir_a_mongodb():
    if not pymongo_disponible:
        print("Error: pymongo no está instalado. No se puede subir a MongoDB.")
        return

    cliente = MongoClient(MONGO_URI)
    db = cliente[DB_NAME]
    coleccion = db[COLLECTION_NAME]
    datos = cargar_datos()
    if datos:
        coleccion.insert_many(datos)
        print("Datos subidos a MongoDB Atlas.")
    else:
        print("No hay datos para subir.")

# Menú para probar las operaciones
if __name__ == "__main__":
    while True:
        print("\n1. Crear muñeca")
        print("2. Leer muñecas")
        print("3. Actualizar muñeca")
        print("4. Eliminar muñeca")
        print("5. Subir a MongoDB Atlas")
        print("6. Salir")
        opcion = input("Elige una opción: ")

        if opcion == "1":
            nombre = input("Nombre de la muñeca: ")
            precio = float(input("Precio de la muñeca: "))
            crear_muñeca(nombre, precio)
        elif opcion == "2":
            leer_muñecas()
        elif opcion == "3":
            id_m = input("ID de la muñeca a actualizar: ")
            nuevo_nombre = input("Nuevo nombre: ")
            nuevo_precio = float(input("Nuevo precio: "))
            actualizar_muñeca(id_m, nuevo_nombre, nuevo_precio)
        elif opcion == "4":
            id_m = input("ID de la muñeca a eliminar: ")
            eliminar_muñeca(id_m)
        elif opcion == "5":
            subir_a_mongodb()
        elif opcion == "6":
            break
        else:
            print("Opción inválida.")
