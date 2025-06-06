import os
import xml.etree.ElementTree as ET

# Función para cargar el archivo XML o crear uno nuevo si no existe
def load_or_create_xml():
    if os.path.exists("scissors.xml"):
        tree = ET.parse("scissors.xml")
        return tree, tree.getroot()
    else:
        root = ET.Element("scissors_list")  # Nodo raíz
        tree = ET.ElementTree(root)
        return tree, root

# Función para agregar una nueva tijera al archivo XML
def add_scissors():
    size = input("Enter the size of the scissors (e.g., small, medium, large): ")
    color = input("Enter the color of the scissors: ")
    orientation = input("Enter the orientation (left or right): ")

    # Cargar archivo XML o crear uno nuevo
    tree, root = load_or_create_xml()

    # Crear un nuevo nodo <scissors> con subnodos <size>, <color>, <orientation>
    scissors = ET.Element("scissors")
    
    size_el = ET.SubElement(scissors, "size")
    size_el.text = size

    color_el = ET.SubElement(scissors, "color")
    color_el.text = color

    orientation_el = ET.SubElement(scissors, "orientation")
    orientation_el.text = orientation

    # Agregar la nueva tijera al nodo raíz
    root.append(scissors)

    # Guardar el archivo
    tree.write("scissors.xml", encoding="utf-8", xml_declaration=True)

    print("\nScissors saved to XML file successfully!")

# Ejecutar la función principal
add_scissors()
