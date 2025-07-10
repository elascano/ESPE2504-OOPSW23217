import tkinter as tk
from tkinter import messagebox
from pymongo import MongoClient

# 🔹 Conectar a MongoDB Atlas
client = MongoClient("mongodb+srv://usuario:contraseña@cluster.mongodb.net/?retryWrites=true&w=majority")
db = client["FlashDriveDB"]
collection = db["flashDrive"]

# 🔹 Función para guardar datos en MongoDB
def save_data():
    brand = brand_entry.get()
    capacity = capacity_entry.get()
    price = price_entry.get()
    color = color_entry.get()

    # 🔹 Validaciones de datos
    if not brand or not capacity or not price or not color:
        messagebox.showerror("Error", "Todos los campos son obligatorios")
        return
    
    if not capacity.isdigit() or int(capacity) <= 0:
        messagebox.showerror("Error", "La capacidad debe ser un número positivo")
        return

    if not price.replace('.', '', 1).isdigit() or float(price) <= 0:
        messagebox.showerror("Error", "El precio debe ser un número válido")
        return

    # 🔹 Cálculo dinámico de precio final
    discount = 0.0

    if int(capacity) >= 128:
        discount += 10.0
    elif int(capacity) >= 64:
        discount += 5.0

    final_price = float(price) - (float(price) * (discount / 100))

    # 🔹 Guardar datos en MongoDB
    flashDrive = {
        "brand": brand,
        "capacityGB": int(capacity),
        "price": float(price),
        "color": color,
        "discountApplied": discount,
        "finalPrice": round(final_price, 2)
    }

    collection.insert_one(flashDrive)  # Insertar en MongoDB
    messagebox.showinfo("Éxito", f"✅ Flash Drive guardado correctamente!\nPrecio final: ${flashDrive['finalPrice']}")
    clear_fields()

# 🔹 Función para limpiar los campos
def clear_fields():
    brand_entry.delete(0, tk.END)
    capacity_entry.delete(0, tk.END)
    price_entry.delete(0, tk.END)
    color_entry.delete(0, tk.END)

# 🔹 Creación de la ventana principal
root = tk.Tk()
root.title("Formulario Flash Drive")
root.geometry("300x300")

# 🔹 Campos de entrada
tk.Label(root, text="Marca:").pack()
brand_entry = tk.Entry(root)
brand_entry.pack()

tk.Label(root, text="Capacidad (GB):").pack()
capacity_entry = tk.Entry(root)
capacity_entry.pack()

tk.Label(root, text="Precio:").pack()
price_entry = tk.Entry(root)
price_entry.pack()

tk.Label(root, text="Color:").pack()
color_entry = tk.Entry(root)
color_entry.pack()

# 🔹 Botón de guardado
save_button = tk.Button(root, text="Guardar en DB", command=save_data)
save_button.pack()

# 🔹 Botón para limpiar los campos
clear_button = tk.Button(root, text="Limpiar", command=clear_fields)
clear_button.pack()

# 🔹 Ejecutar la interfaz gráfica
root.mainloop()