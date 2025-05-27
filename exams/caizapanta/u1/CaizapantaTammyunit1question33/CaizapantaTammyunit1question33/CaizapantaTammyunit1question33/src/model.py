#author:Tammy Caizapanta

from dataclasses import dataclass

@dataclass
class Cable:
    def __init__(self, cable_id,brand,lenght,type):
        self.cable_id=cable_id
        self.brand=brand
        self.lenght=lenght
        self.type=type

    def __str__(self):
        return (f"Chicken{{id={self.cable_id}, brand={self.brand}, lenght={self.lenght}, type={self.type}}}")
    
    def insertData(self):
        print(f"Cable ide --> {self.cable_id}")
        print(f"Cable brand --> {self.brand}")
        print(f"Cable lenght --> {self.lenght}")
        print(f"Cable type --> {self.type}")        

    def showData(self):
        print(f"Cable ide --> {self.cable_id}")
        print(f"Cable brand --> {self.brand}")
        print(f"Cable lenght --> {self.lenght}")
        print(f"Cable type --> {self.type}")  