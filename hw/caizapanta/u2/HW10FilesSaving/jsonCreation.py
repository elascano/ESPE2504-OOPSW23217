import json
import os

# Data dictionary matching your JSON structure
data = {
    "students": [
        {
            "id": 1,
            "brand": "Atlas",
            "lenght": 2,
            "type": "HDMI",
        }
    ]
}

# Get folder where this script is located
script_folder = os.path.dirname(os.path.abspath(__file__))

# Full path for the JSON file
json_path = os.path.join(script_folder, "cable.json")

# Write the JSON file with indentation (pretty print)
with open(json_path, "w", encoding="utf-8") as f:
    json.dump(data, f, indent=2)

print(f"JSON file created at: {json_path}")