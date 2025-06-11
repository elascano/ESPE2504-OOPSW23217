from pymongo import MongoClient

# Clase Student con representación en texto
class Student:
    def __init__(self, id, firstname, lastname, age, salary):
        self.id = id
        self.firstname = firstname
        self.lastname = lastname
        self.age = age
        self.salary = salary

    def to_dict(self):
        return {
            "id": self.id,
            "firstname": self.firstname,
            "lastname": self.lastname,
            "age": self.age,
            "salary": self.salary
        }

    def __str__(self):
        return f"{self.id} - {self.firstname} {self.lastname}, edad: {self.age}, salario: {self.salary}"

    def __repr__(self):
        return self.__str__()

try:
    # Conexión a MongoDB
    client = MongoClient("mongodb+srv://Gerald:Gerald@cluster0.rdplxx4.mongodb.net/")
    db = client["POO"]
    collection = db["Eduplan"]

    # Ingreso de datos por teclado
    id = int(input("ID: "))
    firstname = input("Nombre: ")
    lastname = input("Apellido: ")
    age = int(input("Edad: "))
    salary = float(input("Salario: "))

    new_student = Student(id, firstname, lastname, age, salary)

    # Insertar en el array 'students' del primer documento
    collection.update_one({}, {"$push": {"students": new_student.to_dict()}})
    print("Estudiante agregado correctamente.\n")

    # Leer todos los estudiantes y mostrarlos
    document = collection.find_one()
    student_objects = []

    if "students" in document:
        for s in document["students"]:
            student_obj = Student(s["id"], s["firstname"], s["lastname"], s["age"], s["salary"])
            student_objects.append(student_obj)

    print(f"Total de estudiantes: {len(student_objects)}")
    for student in student_objects:
        print(student)

except Exception as e:
    print("Error:", e)