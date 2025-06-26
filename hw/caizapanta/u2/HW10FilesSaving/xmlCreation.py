import xml.etree.ElementTree as ET
import xml.dom.minidom
import os

def pretty_xml(element):
    rough_string = ET.tostring(element, 'utf-8')
    reparsed = xml.dom.minidom.parseString(rough_string)
    return reparsed.toprettyxml(indent="  ")

# Try to get the folder of the current script; fallback to current working directory
try:
    script_folder = os.path.dirname(os.path.abspath(__file__))
except NameError:
    # __file__ is not defined, e.g., in interactive console
    script_folder = os.getcwd()

# Root element (plural makes sense here)
root = ET.Element("cables")

cable_data = [
    {"id": "1", "brand": "Atlas", "length": 2, "type": "HDMI"}
]

for cable in cable_data:
    cable_element = ET.SubElement(root, "cable")
    for key, value in cable.items():
        field = ET.SubElement(cable_element, key)
        field.text = str(value)  # ensure text is string

# Create the pretty XML string
pretty_xml_str = pretty_xml(root)

# Full path to save file next to script
xml_path = os.path.join(script_folder, "cable.xml")

# Write to file
with open(xml_path, "w", encoding="utf-8") as f:
    f.write(pretty_xml_str)

print(f"Pretty XML file created at: {xml_path}")
