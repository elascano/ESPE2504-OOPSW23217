import tkinter as tk
from tkinter import messagebox
import pymongo

# === Conexión a MongoDB Atlas ===
client = pymongo.MongoClient("mongodb+srv://kjsivinta:kjsivinta@cluster0.timukmv.mongodb.net/")
db = client["crud_muneca"]
coleccion = db["munecas"]

# Factores de calidad
factor_calidad = {
    "Alta": 1.5,
    "Media": 1.2,
    "Baja": 1.0
}

def calcular_costos(precio, calidad):
    factor = factor_calidad.get(calidad, 1.0)
    costo_calidad = round(precio * factor, 2)
    costo_envio = 5.00 if precio < 50 else 10.00
    costo_total = round(precio + costo_calidad + costo_envio, 2)
    return costo_calidad, costo_envio, costo_total

# === Funciones CRUD ===

def crear_muneca():
    nombre = entry_nombre.get().strip()
    precio_str = entry_precio.get().strip()
    calidad = calidad_var.get()

    if not nombre or not precio_str:
        messagebox.showerror("Error", "Todos los campos son obligatorios.")
        return

    try:
        precio = float(precio_str)
    except ValueError:
        messagebox.showerror("Error", "Precio inválido. Ingresa un número.")
        return

    if coleccion.find_one({"nombre": nombre}):
        messagebox.showwarning("Duplicado", "Ya existe una muñeca con ese nombre.")
        return

    costo_calidad, costo_envio, costo_total = calcular_costos(precio, calidad)

    muneca = {
        "nombre": nombre,
        "precio": precio,
        "calidad": calidad,
        "costo_calidad": costo_calidad,
        "costo_envio": costo_envio,
        "costo_total": costo_total
    }

    coleccion.insert_one(muneca)
    messagebox.showinfo("Éxito", "Muñeca registrada.")
    limpiar_campos()

def leer_muneca():
    nombre = entry_nombre.get().strip()
    if not nombre:
        messagebox.showerror("Error", "Debes ingresar el nombre de la muñeca.")
        return

    muneca = coleccion.find_one({"nombre": nombre})
    if muneca:
        entry_precio.delete(0, tk.END)
        entry_precio.insert(0, muneca["precio"])
        calidad_var.set(muneca["calidad"])
        label_resultado.config(
            text=f"Calidad: {muneca['costo_calidad']} | Envío: {muneca['costo_envio']} | Total: {muneca['costo_total']}"
        )
    else:
        messagebox.showinfo("No encontrado", "Muñeca no encontrada.")

def actualizar_muneca():
    nombre = entry_nombre.get().strip()
    precio_str = entry_precio.get().strip()
    calidad = calidad_var.get()

    if not nombre or not precio_str:
        messagebox.showerror("Error", "Todos los campos son obligatorios.")
        return

    try:
        nuevo_precio = float(precio_str)
    except ValueError:
        messagebox.showerror("Error", "Precio inválido. Ingresa un número.")
        return

    costo_calidad, costo_envio, costo_total = calcular_costos(nuevo_precio, calidad)

    resultado = coleccion.update_one(
        {"nombre": nombre},
        {"$set": {
            "precio": nuevo_precio,
            "calidad": calidad,
            "costo_calidad": costo_calidad,
            "costo_envio": costo_envio,
            "costo_total": costo_total
        }}
    )

    if resultado.matched_count:
        messagebox.showinfo("Éxito", "Muñeca actualizada.")
    else:
        messagebox.showwarning("Atención", "No se encontró la muñeca.")
    limpiar_campos()

def eliminar_muneca():
    nombre = entry_nombre.get().strip()
    if not nombre:
        messagebox.showerror("Error", "Debes ingresar el nombre de la muñeca.")
        return

    resultado = coleccion.delete_one({"nombre": nombre})
    if resultado.deleted_count:
        messagebox.showinfo("Éxito", "Muñeca eliminada.")
    else:
        messagebox.showwarning("Atención", "No se encontró la muñeca.")
    limpiar_campos()

def limpiar_campos():
    entry_nombre.delete(0, tk.END)
    entry_precio.delete(0, tk.END)
    calidad_var.set("Media")
    label_resultado.config(text="Resultado:")

# === INTERFAZ GRÁFICA ===
ventana = tk.Tk()
ventana.title("CRUD Muñeca - MongoDB Atlas")
ventana.geometry("330x370")

tk.Label(ventana, text="Nombre de la muñeca").pack()
entry_nombre = tk.Entry(ventana)
entry_nombre.pack()

tk.Label(ventana, text="Precio").pack()
entry_precio = tk.Entry(ventana)
entry_precio.pack()

tk.Label(ventana, text="Calidad").pack()
calidad_var = tk.StringVar(value="Media")
opciones_calidad = ["Alta", "Media", "Baja"]
tk.OptionMenu(ventana, calidad_var, *opciones_calidad).pack()

label_resultado = tk.Label(ventana, text="Resultado:")
label_resultado.pack(pady=6)

tk.Button(ventana, text="Crear", command=crear_muneca, width=25).pack(pady=3)
tk.Button(ventana, text="Leer", command=leer_muneca, width=25).pack(pady=3)
tk.Button(ventana, text="Actualizar", command=actualizar_muneca, width=25).pack(pady=3)
tk.Button(ventana, text="Eliminar", command=eliminar_muneca, width=25).pack(pady=3)

ventana.mainloop()
