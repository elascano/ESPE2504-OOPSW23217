import json
import os

phones = []

count = int(input("How many phones would you like to enter? "))

for i in range(count):
    print(f"\nPhone {i + 1}:")
    phone_id = input("  ID: ")
    brand = input("  Brand: ")
    model = input("  Model: ")
    storage = input("  Storage (in GB): ")
    os_name = input("  Operating System: ")

    phone = {
        "id": phone_id,
        "brand": brand,
        "model": model,
        "storage": storage,
        "os": os_name
    }
    phones.append(phone)

data = {"phones": phones}

try:
    script_folder = os.path.dirname(os.path.abspath(__file__))
except NameError:
    script_folder = os.getcwd()

json_path = os.path.join(script_folder, "phones.json")

with open(json_path, "w", encoding="utf-8") as f:
    json.dump(data, f, indent=2)

print(f"\nJSON file created successfully at:\n{json_path}")
