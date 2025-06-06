import json
import xml.etree.ElementTree as ET
import os


class Goalkeeper:
    def __init__(self, id, name, age, saves):
        self.id = id
        self.name = name
        self.age = age
        self.saves = saves

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "age": self.age,
            "saves": self.saves
        }

    @staticmethod
    def from_dict(data):
        return Goalkeeper(data["id"], data["name"], data["age"], data["saves"])

    def __str__(self):
        return f"Goalkeeper(id={self.id}, name='{self.name}', age={self.age}, saves={self.saves})"


class GoalkeeperJSONHandler:
    def __init__(self, filename):
        self.filename = filename

    def save(self, goalkeepers):
        with open(self.filename, 'w') as file:
            json.dump([gk.to_dict() for gk in goalkeepers], file, indent=4)

    def load(self):
        try:
            with open(self.filename, 'r') as file:
                data = json.load(file)
                return [Goalkeeper.from_dict(item) for item in data]
        except FileNotFoundError:
            print("JSON file not found. Starting with empty list.")
            return []


class GoalkeeperXMLHandler:
    def __init__(self, filename):
        self.filename = filename

    def save(self, goalkeepers):
        root = ET.Element("Goalkeepers")
        for gk in goalkeepers:
            gk_elem = ET.SubElement(root, "Goalkeeper")
            ET.SubElement(gk_elem, "ID").text = str(gk.id)
            ET.SubElement(gk_elem, "Name").text = gk.name
            ET.SubElement(gk_elem, "Age").text = str(gk.age)
            ET.SubElement(gk_elem, "Saves").text = str(gk.saves)

        tree = ET.ElementTree(root)
        tree.write(self.filename, encoding="utf-8", xml_declaration=True)

    def load(self):
        goalkeepers = []
        try:
            tree = ET.parse(self.filename)
            root = tree.getroot()
            for gk_elem in root.findall("Goalkeeper"):
                id = int(gk_elem.find("ID").text)
                name = gk_elem.find("Name").text
                age = int(gk_elem.find("Age").text)
                saves = int(gk_elem.find("Saves").text)
                goalkeepers.append(Goalkeeper(id, name, age, saves))
        except FileNotFoundError:
            print("XML file not found. Starting with empty list.")
        except ET.ParseError:
            print("XML file is malformed.")
        return goalkeepers


class GoalkeeperApp:
    def __init__(self):
        self.json_handler = GoalkeeperJSONHandler("goalkeepers.json")
        self.xml_handler = GoalkeeperXMLHandler("goalkeepers.xml")
        self.goalkeepers = self.json_handler.load()

    def run(self):
        print("=== Goalkeepers Register ===")
        while True:
            try:
                id = int(input("ID: "))
                name = input("Name: ")
                age = int(input("Age: "))
                saves = int(input("Saves: "))
                gk = Goalkeeper(id, name, age, saves)
                self.goalkeepers.append(gk)

                another = input("Add another goalkeeper? (s/n): ").lower()
                if another != 's':
                    break
            except ValueError:
                print("Invalid input. Try again.")

        # Guardar en ambos formatos
        self.json_handler.save(self.goalkeepers)
        self.xml_handler.save(self.goalkeepers)

        print("\n=== Goalkeepers Saved ===")
        for gk in self.goalkeepers:
            print(gk)

        # Mostrar rutas absolutas
        print("\nFiles created:")
        print("- JSON:", os.path.abspath("goalkeepers.json"))
        print("- XML:", os.path.abspath("goalkeepers.xml"))

        # Mostrar contenido JSON
        print("\n=== JSON Output ===")
        with open("goalkeepers.json", "r") as file:
            print(file.read())

        # Mostrar contenido XML
        print("\n=== XML Output ===")
        with open("goalkeepers.xml", "r", encoding="utf-8") as file:
            print(file.read())


if __name__ == "__main__":
    app = GoalkeeperApp()
    app.run()
