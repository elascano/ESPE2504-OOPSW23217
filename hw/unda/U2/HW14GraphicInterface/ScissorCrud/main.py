import tkinter as tk
from tkinter import messagebox
from scissors_manager import create_scissor

# Opciones predefinidas
names = ["Tijera escolar", "Tijera de costura", "Tijera industrial", "Tijera punta roma"]
brands = ["Faber-Castell", "Maped", "Tramontina", "Stanley"]

# Función para agregar tijera
def add_scissor():
    name = selected_name.get()
    brand = selected_brand.get()
    try:
        price = float(entry_price.get())
    except ValueError:
        messagebox.showerror("Error", "Precio inválido")
        return

    if name and brand and price:
        data = {"name": name, "brand": brand, "price": price}
        create_scissor(data)
        messagebox.showinfo("Éxito", "Tijera agregada")
    else:
        messagebox.showwarning("Error", "Por favor completa todos los campos")

# Interfaz
root = tk.Tk()
root.title("Scissors CRUD")

# Nombre
tk.Label(root, text="Nombre:").pack()
selected_name = tk.StringVar()
selected_name.set(names[0])  # Valor por defecto
tk.OptionMenu(root, selected_name, *names).pack()

# Marca
tk.Label(root, text="Marca:").pack()
selected_brand = tk.StringVar()
selected_brand.set(brands[0])
tk.OptionMenu(root, selected_brand, *brands).pack()

# Precio (este sí es campo de texto)
tk.Label(root, text="Precio:").pack()
entry_price = tk.Entry(root)
entry_price.pack()

# Botón para agregar
tk.Button(root, text="Agregar Tijera", command=add_scissor).pack()

root.mainloop()
