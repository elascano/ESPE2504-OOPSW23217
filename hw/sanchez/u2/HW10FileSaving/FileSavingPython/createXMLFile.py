import xml.etree.ElementTree as ET


root = ET.Element("library")


book = ET.SubElement(root, "Book")
book.set("id", "1")  


title = ET.SubElement(book, "title")
title.text = "El Principito"

autor = ET.SubElement(book, "autor")
autor.text = "Antoine de Saint-Exupéry"


tree = ET.ElementTree(root)
with open("library.xml", "wb") as file:
    tree.write(file, encoding="utf-8", xml_declaration=True)