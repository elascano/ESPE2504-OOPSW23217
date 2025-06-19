from pymongo import MongoClient

# Tasas de cambio fijas de ejemplo
CURRENCY_RATES = {
    "USD": 1.0,
    "EUR": 0.92,
    "MXN": 18.5,
    "JPY": 157.0
}

class SoundMixer:
    def __init__(self, brand, model, is_digital, num_channels, price_usd, serial_number):
        self.brand = brand
        self.model = model
        self.is_digital = is_digital
        self.num_channels = num_channels
        self.price_usd = price_usd  # Siempre en USD
        self.serial_number = serial_number

    def to_dict(self):
        return {
            "brand": self.brand,
            "model": self.model,
            "isDigital": self.is_digital,
            "numChannels": self.num_channels,
            "price": self.price_usd,
            "serialNumber": self.serial_number
        }

    def __str__(self):
        tipo = "Digital" if self.is_digital else "Analogico"
        return (f"{self.brand} {self.model} | Tipo: {tipo} | "
                f"Canales: {self.num_channels} | Precio (USD): {self.price_usd:.2f} | Serial: {self.serial_number}")

def convert_price(price_usd, to_currency):
    rate = CURRENCY_RATES.get(to_currency, 1.0)
    return price_usd * rate

def input_sound_mixer():
    brand = input("Brand: ")
    model = input("Model: ")
    tipo = input("Type (Analogico/Digital): ").strip().lower()
    is_digital = True if tipo == "digital" else False
    num_channels = int(input("Number of channels: "))
    price_usd = float(input("Price (USD): "))
    serial_number = input("Serial number: ")
    return SoundMixer(brand, model, is_digital, num_channels, price_usd, serial_number)

def show_mixers(collection):
    print("\n--- Lista de Sound Mixers ---")
    for doc in collection.find():
        mixer = SoundMixer(
            doc["brand"], doc["model"], doc["isDigital"], doc["numChannels"], doc["price"], doc["serialNumber"]
        )
        print(mixer)
    print("-----------------------------\n")

def main():
    try:
        client = MongoClient("mongodb+srv://Gerald:Gerald@cluster0.ii5j1oo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
        db = client["POO"]
        collection = db["SoundMixerDb"]

        while True:
            print("1. Añadir sound mixer")
            print("2. Buscar sound mixer por serial")
            print("3. Actualizar sound mixer por serial")
            print("4. Eliminar sound mixer por serial")
            print("5. Mostrar todos los sound mixers")
            print("6. Mostrar precio en otra moneda")
            print("0. Salir")
            op = input("Opción: ")

            if op == "1":
                mixer = input_sound_mixer()
                # Verifica si ya existe un sound mixer con ese serial
                if collection.find_one({"serialNumber": mixer.serial_number}):
                    print("Ya existe un sound mixer con ese número de serie.\n")
                else:
                    collection.insert_one(mixer.to_dict())
                    print("Sound mixer agregado correctamente.\n")

            elif op == "2":
                serial = input("Ingrese el número de serie a buscar: ")
                doc = collection.find_one({"serialNumber": serial})
                if doc:
                    mixer = SoundMixer(
                        doc["brand"], doc["model"], doc["isDigital"], doc["numChannels"], doc["price"], doc["serialNumber"]
                    )
                    print("Sound mixer encontrado:")
                    print(mixer)
                else:
                    print("No existe un sound mixer con ese número de serie.\n")

            elif op == "3":
                serial = input("Ingrese el número de serie a actualizar: ")
                doc = collection.find_one({"serialNumber": serial})
                if not doc:
                    print("Debe buscar primero el sound mixer antes de actualizar.\n")
                    continue
                print("Ingrese los nuevos datos (deje vacío para mantener el valor actual):")
                brand = input(f"Brand [{doc['brand']}]: ") or doc["brand"]
                model = input(f"Model [{doc['model']}]: ") or doc["model"]
                tipo = input(f"Type (Analogico/Digital) [{'Digital' if doc['isDigital'] else 'Analogico'}]: ")
                is_digital = doc["isDigital"] if not tipo else (True if tipo.lower() == "digital" else False)
                channels_input = input(f"Number of channels [{doc['numChannels']}]: ")
                num_channels = int(channels_input) if channels_input else doc["numChannels"]
                price_input = input(f"Price (USD) [{doc['price']}]: ")
                price_usd = float(price_input) if price_input else doc["price"]
                update_doc = {
                    "brand": brand,
                    "model": model,
                    "isDigital": is_digital,
                    "numChannels": num_channels,
                    "price": price_usd,
                    "serialNumber": serial
                }
                collection.update_one({"serialNumber": serial}, {"$set": update_doc})
                print("Sound mixer actualizado correctamente.\n")

            elif op == "4":
                serial = input("Ingrese el número de serie a eliminar: ")
                doc = collection.find_one({"serialNumber": serial})
                if not doc:
                    print("Debe buscar primero el sound mixer antes de eliminar.\n")
                    continue
                collection.delete_one({"serialNumber": serial})
                print("Sound mixer eliminado correctamente.\n")

            elif op == "5":
                show_mixers(collection)

            elif op == "6":
                serial = input("Ingrese el número de serie: ")
                doc = collection.find_one({"serialNumber": serial})
                if not doc:
                    print("No existe un sound mixer con ese número de serie.\n")
                    continue
                print("Monedas disponibles: USD, EUR, MXN, JPY")
                moneda = input("Ingrese la moneda: ").upper()
                if moneda not in CURRENCY_RATES:
                    print("Moneda no válida.\n")
                    continue
                price_usd = doc["price"]
                price_conv = convert_price(price_usd, moneda)
                print(f"Precio de {doc['brand']} {doc['model']} en {moneda}: {price_conv:.2f} {moneda}\n")

            elif op == "0":
                print("Saliendo...")
                break

            else:
                print("Opción no válida.\n")

    except Exception as e:
        print("Error:", e)

if __name__ == "__main__":
    main()