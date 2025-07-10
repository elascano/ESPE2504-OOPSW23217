import json
import os
data = {
    "id" : 1,
    "firstname" : "Marco",
    "lastname" : "Petro",
    "age" : 18,
    "salary" : 0
}

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