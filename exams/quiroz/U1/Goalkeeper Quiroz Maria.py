#Goalkeeper Quiroz Maria

import csv


class Goalkeeper:
    def __init__(self, id, name, age, saves):
        self.id = id
        self.name = name
        self.age = age
        self.saves = saves

    def to_list(self):
        return [self.id, self.name, self.age, self.saves]

    @staticmethod
    def from_list(data):
        return Goalkeeper(int(data[0]), data[1], int(data[2]), int(data[3]))

    def __str__(self):
        return f"Goalkeeper(id={self.id}, name='{self.name}', age={self.age}, saves={self.saves})"


class GoalkeeperCSVHandler:
    def __init__(self, filename):
        self.filename = filename

    def save(self, goalkeepers):
        with open(self.filename, 'w', newline='') as file:
            writer = csv.writer(file)
            for gk in goalkeepers:
                writer.writerow(gk.to_list())

    def load(self):
        goalkeepers = []
        try:
            with open(self.filename, 'r') as file:
                reader = csv.reader(file)
                for row in reader:
                    if row:
                        goalkeepers.append(Goalkeeper.from_list(row))
        except FileNotFoundError:
            print("File does not found, It will be registred like empty.")
        return goalkeepers


class GoalkeeperApp:
    def __init__(self):
        self.handler = GoalkeeperCSVHandler("goalkeepers.csv")
        self.goalkeepers = self.handler.load()

    def run(self):
        print("=== Goalkeepers register ===")
        while True:
            try:
                id = int(input("ID: "))
                name = input("Name: ")
                age = int(input("Age: "))
                saves = int(input("Shortcuts: "))
                gk = Goalkeeper(id, name, age, saves)
                self.goalkeepers.append(gk)

                another = input("¿Add other goalkeeper? (s/n): ").lower()
                if another != 's':
                    break
            except ValueError:
                print("Invalid option. Try again.")

        
        self.handler.save(self.goalkeepers)

        
        print("\n=== Goalkeepers saved ===")
        for gk in self.goalkeepers:
            print(gk)


if __name__ == "__main__":
    app = GoalkeeperApp()
    app.run()
