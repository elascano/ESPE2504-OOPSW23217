import json
import os

class estudents:
    def __init__(self, id, name, lastName, age, salary):
        self.lastName = lastName
        self.age = age
        self.id = id
        self.name = name
        self.salary = salary
        
    def to_dict(self):
        return {
            "id": self.id,
            "lastName": self.lastName,
            "age": self.age,
            "salary": self.salary,
            "name": self.name
        }

EstudentsCreate = []
archivo_json = "estudiantes.json"

if os.path.exists(archivo_json):
    with open(archivo_json, "r", encoding="utf-8") as file:
        data = json.load(file)
        for element in data:
            EstudentsCreate.append(estudents(
                element["id"], 
                element["name"], 
                element["lastName"], 
                element["age"], 
                element["salary"]
            ))
else:
    data = []

while True:
    try:
        id = int(input("Ingrese el ID del estudiante: "))
        name = input("Ingrese el nombre del estudiante: ")
        lastName = input("Ingrese el apellido del estudiante: ")
        age = int(input("Ingrese la edad del estudiante: "))
        salary = float(input("Ingrese el salario del estudiante: "))
        
        EstudentsCreate.append(estudents(id, name, lastName, age, salary))
        
        continuar = input("¿Desea agregar otro estudiante? (s/n): ").lower()
        if continuar != 's':
            break
    except ValueError as e:
        print(f"Error de entrada: {e}. Por favor, intente de nuevo.")

with open(archivo_json, "w", encoding="utf-8") as file:
    json.dump([est.to_dict() for est in EstudentsCreate], file, indent=4, ensure_ascii=False)

print("Archivo JSON creado exitosamente con los datos de estudiantes.")