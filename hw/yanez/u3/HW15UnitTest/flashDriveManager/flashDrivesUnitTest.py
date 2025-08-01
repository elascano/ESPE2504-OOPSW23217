import tkinter as tk
from tkinter import messagebox, ttk
from pymongo import MongoClient
from bson.objectid import ObjectId

# --- Conexión a MongoDB ---
client = MongoClient("mongodb+srv://jgyanez2:jgyanez2@cluster0.bdnssw7.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
db = client["WarGame"]
collection = db["flashDrive"]

selected_id = None

def create_flashdrive():
    try:
        price = float(price_var.get())
        discount = float(discount_var.get())
        final_price = round(price * (1 - discount / 100), 2)

        doc = {
            "brand": brand_var.get(),
            "capacityGB": int(capacity_var.get()),
            "price": price,
            "color": color_var.get(),
            "usbType": usb_type_var.get(),
            "stock": int(stock_var.get()),
            "warrantyMonths": int(warranty_var.get()),
            "discountPercentage": discount,
            "finalPrice": final_price
        }
        collection.insert_one(doc)
        messagebox.showinfo("Éxito", "Flash drive agregado.")
        load_flashdrives()
        clear_fields()
    except Exception as e:
        messagebox.showerror("Error", str(e))

def update_flashdrive():
    global selected_id
    if not selected_id:
        messagebox.showwarning("Advertencia", "Seleccione un registro para actualizar.")
        return
    try:
        price = float(price_var.get())
        discount = float(discount_var.get())
        final_price = round(price * (1 - discount / 100), 2)

        updated_doc = {
            "brand": brand_var.get(),
            "capacityGB": int(capacity_var.get()),
            "price": price,
            "color": color_var.get(),
            "usbType": usb_type_var.get(),
            "stock": int(stock_var.get()),
            "warrantyMonths": int(warranty_var.get()),
            "discountPercentage": discount,
            "finalPrice": final_price
        }
        collection.update_one({"_id": ObjectId(selected_id)}, {"$set": updated_doc})
        messagebox.showinfo("Actualizado", "Datos actualizados.")
        load_flashdrives()
        clear_fields()
    except Exception as e:
        messagebox.showerror("Error", str(e))

def delete_flashdrive():
    global selected_id
    if not selected_id:
        messagebox.showwarning("Advertencia", "Seleccione un registro para eliminar.")
        return
    try:
        collection.delete_one({"_id": ObjectId(selected_id)})
        messagebox.showinfo("Eliminado", "Flash drive eliminado.")
        load_flashdrives()
        clear_fields()
    except Exception as e:
        messagebox.showerror("Error", str(e))

def load_flashdrives():
    tree.delete(*tree.get_children())
    for doc in collection.find():
        tree.insert("", "end", iid=str(doc["_id"]), values=(
            doc.get("brand", ""),
            doc.get("capacityGB", ""),
            doc.get("price", ""),
            doc.get("color", ""),
            doc.get("usbType", ""),
            doc.get("stock", ""),
            doc.get("warrantyMonths", ""),
            doc.get("discountPercentage", ""),
            doc.get("finalPrice", "")
        ))

def on_select(event):
    global selected_id
    selected = tree.focus()
    if not selected:
        return
    selected_id = selected
    values = tree.item(selected, "valores")
    for var, val in zip(entry_vars, values):
        var.set(val)

def clear_fields():
    global selected_id
    for var in entry_vars:
        var.set("")
    selected_id = None

def calculate_summary():
    docs = list(collection.find())
    if not docs:
        messagebox.showinfo("Resumen", "No hay datos.")
        return
    avg_price = sum(doc["finalPrice"] for doc in docs) / len(docs)
    total_capacity = sum(doc["capacityGB"] for doc in docs)
    messagebox.showinfo("Resumen",
                        f"Precio promedio final: ${avg_price:.2f}\nCapacidad total: {total_capacity} GB")

root = tk.Tk()
root.title("Flash Drive Manager - WarGame")
root.geometry("1000x600")

brand_var = tk.StringVar()
capacity_var = tk.StringVar()
price_var = tk.StringVar()
color_var = tk.StringVar()
usb_type_var = tk.StringVar()
stock_var = tk.StringVar()
warranty_var = tk.StringVar()
discount_var = tk.StringVar()
entry_vars = [brand_var, capacity_var, price_var, color_var,
              usb_type_var, stock_var, warranty_var, discount_var]

labels = ["Marca", "Capacidad (GB)", "Precio", "Color", "USB Tipo", "Stock", "Garantía (meses)", "Descuento (%)"]

for i, (label, var) in enumerate(zip(labels, entry_vars)):
    tk.Label(root, text=label).grid(row=i, column=0, sticky="e", padx=5, pady=5)
    tk.Entry(root, textvariable=var).grid(row=i, column=1, padx=5, pady=5)

# Botones
tk.Button(root, text="Agregar", width=15, command=create_flashdrive).grid(row=0, column=2, padx=10)
tk.Button(root, text="Actualizar", width=15, command=update_flashdrive).grid(row=1, column=2, padx=10)
tk.Button(root, text="Eliminar", width=15, command=delete_flashdrive).grid(row=2, column=2, padx=10)
tk.Button(root, text="Resumen", width=15, command=calculate_summary).grid(row=3, column=2, padx=10)
tk.Button(root, text="Limpiar", width=15, command=clear_fields).grid(row=4, column=2, padx=10)

cols = ["Marca", "Capacidad", "Precio", "Color", "USB", "Stock", "Garantía", "Descuento", "Precio Final"]
tree = ttk.Treeview(root, columns=cols, show="headings", height=15)
for col in cols:
    tree.heading(col, text=col)
    tree.column(col, width=100)
tree.grid(row=10, column=0, columnspan=3, padx=10, pady=20)
tree.bind("<<TreeviewSelect>>", on_select)

load_flashdrives()
root.mainloop()
