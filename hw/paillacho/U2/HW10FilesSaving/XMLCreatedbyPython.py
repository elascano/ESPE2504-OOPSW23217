import xml.etree.ElementTree as ET
import xml.dom.minidom
import os


def pretty_xml(element):
    rough_string = ET.tostring(element, 'utf-8')
    reparsed = xml.dom.minidom.parseString(rough_string)
    return reparsed.toprettyxml(indent="  ")


root = ET.Element("phones")


count = int(input("How many phones would you like to enter? "))


for i in range(count):
    print(f"\nPhone {i + 1}:")
    phone_id = input("  ID: ")
    brand = input("  Brand: ")
    model = input("  Model: ")
    storage = input("  Storage (in GB): ")
    os_name = input("  Operating System: ")

    phone = ET.SubElement(root, "phone")
    ET.SubElement(phone, "id").text = phone_id
    ET.SubElement(phone, "brand").text = brand
    ET.SubElement(phone, "model").text = model
    ET.SubElement(phone, "storage").text = storage
    ET.SubElement(phone, "os").text = os_name


pretty_xml_str = pretty_xml(root)


try:
    script_folder = os.path.dirname(os.path.abspath(__file__))
except NameError:
    script_folder = os.getcwd()

xml_path = os.path.join(script_folder, "phones.xml")


with open(xml_path, "w", encoding="utf-8") as f:
    f.write(pretty_xml_str)

print(f"\nXML file created successfully at:\n{xml_path}")

# Creted by Carlos
