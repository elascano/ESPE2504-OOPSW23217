import csv

class Doll:
    def __init__(self, id, name, material, price):
        self.id = id
        self.name = name
        self.material = material
        self.price = price

    def __str__(self):
        return f"Doll(ID: {self.id}, Name: {self.name}, Material: {self.material}, Price: {self.price})"

class DollManager:
    def __init__(self):
        self.dolls = []

    def add_doll(self, doll):
        self.dolls.append(doll)

    def save_to_csv(self, filename):
        with open(filename, mode='w', newline='') as file:
            writer = csv.writer(file)
            writer.writerow(["ID", "Name", "Material", "Price"])
            for doll in self.dolls:
                writer.writerow([doll.id, doll.name, doll.material, doll.price])

    def load_from_csv(self, filename):
        with open(filename, mode='r') as file:
            reader = csv.reader(file)
            next(reader)  # Saltar la cabecera
            for row in reader:
                id, name, material, price = row
                self.dolls.append(Doll(id, name, material, float(price)))

    def display_dolls(self):
        for doll in self.dolls:
            print(doll)

# Ejemplo de uso
manager = DollManager()
manager.add_doll(Doll(1, "Barbie", "Plastic", 19.99))
manager.add_doll(Doll(2, "Rag Doll", "Fabric", 12.50))

# Guardar en CSV
manager.save_to_csv("dolls.csv")

# Leer desde CSV
manager.load_from_csv("dolls.csv")
manager.display_dolls()
