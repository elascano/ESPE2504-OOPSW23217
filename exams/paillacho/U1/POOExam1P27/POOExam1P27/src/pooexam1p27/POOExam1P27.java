import csv

class Stand:
    def __init__(self, id, name, location, available):
        self.id = id
        self.name = name
        self.location = location
        self.available = available

    def to_list(self):
        return [self.id, self.name, self.location, str(self.available)]

    @classmethod
    def from_list(cls, data_list):
        return cls(
            id=data_list[0],
            name=data_list[1],
            location=data_list[2],
            available=data_list[3].lower() == 'true'
        )

def save_stands_to_csv(filename, stand_list):
    with open(filename, mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['id', 'name', 'location', 'available'])  # headers
        for stand in stand_list:
            writer.writerow(stand.to_list())

def read_stands_from_csv(filename):
    stand_list = []
    with open(filename, mode='r') as file:
        reader = csv.reader(file)
        next(reader)  # Skip headers
        for row in reader:
            stand_list.append(Stand.from_list(row))
    return stand_list

if __name__ == "__main__":
    # Create some Stand objects
    stand1 = Stand("001", "Food Stand", "Zone A", True)
    stand2 = Stand("002", "Crafts Stand", "Zone B", False)
    stands = [stand1, stand2]

  
    save_stands_to_csv("stands.csv", stands)

   
    loaded_stands = read_stands_from_csv("stands.csv")
    for stand in loaded_stands:
        print(f"ID: {stand.id}, Name: {stand.name}, Location: {stand.location}, Available: {stand.available}")
