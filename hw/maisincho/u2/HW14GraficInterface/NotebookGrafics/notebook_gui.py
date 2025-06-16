import tkinter as tk
from tkinter import messagebox, simpledialog
from pymongo import MongoClient

connectionString = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=false&w=majority"

def get_collection():
    client = MongoClient(connectionString)
    db = client["dbmongo"]
    return db["notebook"]

# ---------- Funciones de CRUD ----------
def insertar_notebook():
    try:
        id = int(entry_id.get())
        stock = int(entry_stock.get())
        price = float(entry_price.get().replace(',', '.'))
        tipo = entry_tipo.get().strip()
        design = entry_design.get().strip()
        size = entry_size.get().strip()
        brand = entry_brand.get().strip()

        col = get_collection()
        if col.find_one({"id": id}):
            messagebox.showerror("Error", f"Ya existe un notebook con ID {id}")
            return

        col.insert_one({
            "id": id, "stock": stock, "price": price,
            "type": tipo, "desing": design, "size": size, "brand": brand
        })
        messagebox.showinfo("Éxito", "Notebook insertado correctamente")
        limpiar_campos()
    except Exception as e:
        messagebox.showerror("Error", str(e))

def listar_notebooks():
    try:
        col = get_collection()
        text_output.delete("1.0", tk.END)
        for nb in col.find():
            text_output.insert(tk.END, f"{nb}\n")
    except Exception as e:
        messagebox.showerror("Error", str(e))

def actualizar_notebook():
    try:
        id = int(entry_id.get())
        stock = int(entry_stock.get())
        price = float(entry_price.get().replace(',', '.'))

        col = get_collection()
        result = col.update_one({"id": id}, {"$set": {"stock": stock, "price": price}})
        if result.matched_count:
            messagebox.showinfo("Actualizado", "Notebook actualizado")
        else:
            messagebox.showwarning("No encontrado", "No existe notebook con ese ID")
    except Exception as e:
        messagebox.showerror("Error", str(e))

def eliminar_notebook():
    try:
        id = int(entry_id.get())
        col = get_collection()
        result = col.delete_one({"id": id})
        if result.deleted_count:
            messagebox.showinfo("Eliminado", "Notebook eliminado")
        else:
            messagebox.showwarning("No encontrado", "No existe notebook con ese ID")
    except Exception as e:
        messagebox.showerror("Error", str(e))

# ---------- Función de compra ----------
def comprar_notebook():
    try:
        col = get_collection()
        listar_notebooks()
        id = int(simpledialog.askstring("Compra", "Ingrese el ID del notebook a comprar:"))
        cantidad = int(simpledialog.askstring("Compra", "Ingrese la cantidad a comprar:"))

        notebook = col.find_one({"id": id})
        if not notebook:
            messagebox.showwarning("No encontrado", "Notebook no existe")
            return

        stock = notebook["stock"]
        price = notebook["price"]

        if cantidad > stock:
            messagebox.showerror("Sin stock", "No hay suficiente stock")
            return

        total = price * cantidad
        if total > 20:
            total *= 0.90
            descuento = "10%"
        elif total > 5:
            total *= 0.95
            descuento = "5%"
        else:
            descuento = "0%"

        col.update_one({"id": id}, {"$inc": {"stock": -cantidad}})

        messagebox.showinfo("Compra exitosa",
            f"Compraste {cantidad} unidades\n"
            f"Descuento aplicado: {descuento}\n"
            f"Total a pagar: {round(total, 2)}")
    except Exception as e:
        messagebox.showerror("Error", str(e))

# ---------- GUI ----------
def limpiar_campos():
    entry_id.delete(0, tk.END)
    entry_stock.delete(0, tk.END)
    entry_price.delete(0, tk.END)
    entry_tipo.delete(0, tk.END)
    entry_design.delete(0, tk.END)
    entry_size.delete(0, tk.END)
    entry_brand.delete(0, tk.END)

root = tk.Tk()
root.title("Gestión de Notebooks")
root.geometry("550x650")

# ---------- Entradas ----------
labels = ["ID", "Stock", "Precio", "Tipo", "Diseño", "Tamaño", "Marca"]
entries = []

for i, text in enumerate(labels):
    tk.Label(root, text=text).grid(row=i, column=0, sticky="e")
    entry = tk.Entry(root)
    entry.grid(row=i, column=1, padx=5, pady=5)
    entries.append(entry)

entry_id, entry_stock, entry_price, entry_tipo, entry_design, entry_size, entry_brand = entries

# ---------- Botones ----------
tk.Button(root, text="Insertar", command=insertar_notebook, width=20).grid(row=7, column=0, pady=10)
tk.Button(root, text="Listar", command=listar_notebooks, width=20).grid(row=7, column=1)
tk.Button(root, text="Actualizar", command=actualizar_notebook, width=20).grid(row=8, column=0)
tk.Button(root, text="Eliminar", command=eliminar_notebook, width=20).grid(row=8, column=1)
tk.Button(root, text="Comprar Notebook", command=comprar_notebook, width=42).grid(row=9, column=0, columnspan=2, pady=10)

# ---------- Salida (Lista de notebooks) ----------
tk.Label(root, text="Lista de Notebooks:").grid(row=10, column=0, columnspan=2)
text_output = tk.Text(root, height=15, width=65)
text_output.grid(row=11, column=0, columnspan=2, padx=10, pady=5)

root.mainloop()
