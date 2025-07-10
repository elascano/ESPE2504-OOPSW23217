flashDrive
from pymongo import MongoClient
from bson.objectid import ObjectId

# Conexión a MongoDB
client = MongoClient("mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
db = client["FlashDrivesDB"]
collection = db["flashDrive"]  # Aquí el nombre correcto

def calcular_final_price(price, discount):
    return round(price * (1 - discount / 100), 2)

def create_flash_drive():
    brand = input("Marca del flash drive: ")
    capacity_gb = int(input("Capacidad (GB): "))
    price = float(input("Precio: "))
    color = input("Color: ")
    usb_type = input("Tipo USB (ej. USB 2.0, USB 3.0): ")
    stock = int(input("Stock disponible: "))
    warranty_months = int(input("Meses de garantía: "))
    discount_percentage = float(input("Porcentaje de descuento (0 si no aplica): "))

    final_price = calcular_final_price(price, discount_percentage)

    data = {
        "brand": brand,
        "capacityGB": capacity_gb,
        "price": price,
        "color": color,
        "usbType": usb_type,
        "stock": stock,
        "warrantyMonths": warranty_months,
        "discountPercentage": discount_percentage,
        "finalPrice": final_price
    }
    collection.insert_one(data)
    print("Flash drive agregado con éxito.\n")

def read_flash_drives():
    print("📋 Lista de flash drives registrados:")
    for fd in collection.find():
        print(f"- ID: {fd['_id']}")
        print(f"  Marca: {fd['brand']}")
        print(f"  Capacidad: {fd['capacityGB']} GB")
        print(f"  Precio: ${fd['price']}")
        print(f"  Color: {fd['color']}")
        print(f"  Tipo USB: {fd['usbType']}")
        print(f"  Stock: {fd['stock']}")
        print(f"  Garantía: {fd['warrantyMonths']} meses")
        print(f"  Descuento: {fd['discountPercentage']}%")
        print(f"  Precio final: ${fd['finalPrice']}\n")

def update_flash_drive():
    fd_id = input("ID del flash drive a actualizar: ")
    try:
        obj_id = ObjectId(fd_id)
    except:
        print("ID inválido.\n")
        return

    existing = collection.find_one({"_id": obj_id})
    if not existing:
        print("No se encontró el flash drive.\n")
        return

    brand = input(f"Marca ({existing['brand']}): ") or existing['brand']
    capacity_gb = input(f"Capacidad (GB) ({existing['capacityGB']}): ")
    capacity_gb = int(capacity_gb) if capacity_gb else existing['capacityGB']
    price = input(f"Precio ({existing['price']}): ")
    price = float(price) if price else existing['price']
    color = input(f"Color ({existing['color']}): ") or existing['color']
    usb_type = input(f"Tipo USB ({existing['usbType']}): ") or existing['usbType']
    stock = input(f"Stock ({existing['stock']}): ")
    stock = int(stock) if stock else existing['stock']
    warranty_months = input(f"Meses de garantía ({existing['warrantyMonths']}): ")
    warranty_months = int(warranty_months) if warranty_months else existing['warrantyMonths']
    discount_percentage = input(f"Porcentaje de descuento ({existing['discountPercentage']}): ")
    discount_percentage = float(discount_percentage) if discount_percentage else existing['discountPercentage']

    final_price = calcular_final_price(price, discount_percentage)

    result = collection.update_one(
        {"_id": obj_id},
        {"$set": {
            "brand": brand,
            "capacityGB": capacity_gb,
            "price": price,
            "color": color,
            "usbType": usb_type,
            "stock": stock,
            "warrantyMonths": warranty_months,
            "discountPercentage": discount_percentage,
            "finalPrice": final_price
        }}
    )

    if result.modified_count:
        print("Flash drive actualizado.\n")
    else:
        print("No hubo cambios en el flash drive.\n")

def delete_flash_drive():
    fd_id = input("ID del flash drive a eliminar: ")
    try:
        obj_id = ObjectId(fd_id)
    except:
        print("ID inválido.\n")
        return

    result = collection.delete_one({"_id": obj_id})
    if result.deleted_count:
        print("Flash drive eliminado.\n")
    else:
        print("No se encontró el flash drive.\n")

def main():
    while True:
        print("=== MENÚ CRUD Flash Drives ===")
        print("1. Agregar flash drive")
        print("2. Ver flash drives")
        print("3. Actualizar flash drive")
        print("4. Eliminar flash drive")
        print("5. Salir")
        option = input("Elige una opción (1-5): ")

        if option == "1":
            create_flash_drive()
        elif option == "2":
            read_flash_drives()
        elif option == "3":
            update_flash_drive()
        elif option == "4":
            delete_flash_drive()
        elif option == "5":
            print("Saliendo del programa.")
            break
        else:
            print("Opción no válida.\n")

if __name__ == "__main__":
    main()
