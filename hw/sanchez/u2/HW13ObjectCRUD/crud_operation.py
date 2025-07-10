import json
import os
from pymongo import MongoClient


mongoClient = MongoClient("mongodb+srv://esteban474sanchez:Yesteb@cluster0.rpbnucr.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
data_base = mongoClient["Homework"]
collection = data_base["HW11MongoDB"]


data = {
    "id": 1,
    "firstname": "Marco",
    "lastname": "Petro",
    "age": 18,
    "salary": 0
}


def create_document(doc):
    if collection.count_documents({"id": doc["id"]}) == 0:
        result = collection.insert_one(doc)
        print(f"successfull operation: {result.inserted_id}")
    else:
        print(f"Exist a daata with this id = {doc['id']}")


def read_document_by_id(id_value):
    print(f"read {id_value}:")
    results = collection.find({"id": id_value})
    for doc in results:
        print(doc)


def update_document(id_value, updated_fields):
    result = collection.update_one(
        {"id": id_value},            
        {"$set": updated_fields}       
    )
    if result.modified_count > 0:
        print(f"successfull operation: {id_value}")
    else:
        print(f"Don't found that information")


def delete_document(id_value):
    result = collection.delete_one({"id": id_value})
    if result.deleted_count > 0:
        print(f"operation successfull{id_value} ")
    else:
        print(f" Don't found that information: {id_value}")



create_document(data)


read_document_by_id(1)


update_document(1, {"salary": 500, "age": 19})


read_document_by_id(1)


delete_document(1)


read_document_by_id(1)

"""
json_file = "students.json"

if os.path.exists(json_file):
    with open(json_file, "r", encoding="utf-8") as file:
        file_data = json.load(file)
else:
    file_data = []

file_data.append(data)

with open("students.json", "w", encoding="utf-8") as file:
    json.dump(data, file, indent=4, ensure_ascii=False)

print("JSON file was create...")
"""

