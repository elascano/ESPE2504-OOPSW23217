import tkinter as tk
from tkinter import ttk, messagebox
from controller.MongoConnection import MongoConnection
from model.University import University
from model.UniversityBusiness import UniversityBusiness

class MainGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Gestión de Universidades")
        self.mongo = MongoConnection()
        
        self.frame_menu = tk.Frame(root)
        self.frame_menu.pack(pady=20)

        self.btn_insertar = tk.Button(self.frame_menu, text="Insertar", width=20, command=self.mostrar_insertar)
        self.btn_insertar.pack(side=tk.LEFT, padx=10)

        self.btn_calcular = tk.Button(self.frame_menu, text="Calcular", width=20, command=self.mostrar_calcular)
        self.btn_calcular.pack(side=tk.LEFT, padx=10)

        self.frame_principal = tk.Frame(root)
        self.frame_principal.pack()

    def limpiar_frame_principal(self):
        for widget in self.frame_principal.winfo_children():
            widget.destroy()

    def mostrar_insertar(self):
        self.limpiar_frame_principal()

        universidades = self.mongo.get_universities()

        # Tabla
        cols = ("ID", "Nombre", "Ingreso mensual", "Nº estudiantes")
        tabla = ttk.Treeview(self.frame_principal, columns=cols, show="headings")
        for col in cols:
            tabla.heading(col, text=col)
        tabla.pack()

        for u in universidades:
            tabla.insert("", "end", values=(u.id, u.name, u.monthlyIncome, u.numberOfStudent))

        # Formulario de entrada
        tk.Label(self.frame_principal, text="ID:").pack()
        entry_id = tk.Entry(self.frame_principal)
        entry_id.pack()

        tk.Label(self.frame_principal, text="Nombre:").pack()
        entry_name = tk.Entry(self.frame_principal)
        entry_name.pack()

        tk.Label(self.frame_principal, text="Ingreso mensual:").pack()
        entry_income = tk.Entry(self.frame_principal)
        entry_income.pack()

        tk.Label(self.frame_principal, text="Nº Estudiantes:").pack()
        entry_students = tk.Entry(self.frame_principal)
        entry_students.pack()

        def guardar():
            try:
                u = University(
                    entry_id.get(),
                    entry_name.get(),
                    float(entry_income.get()),
                    int(entry_students.get())
                )
                self.mongo.db["university"].insert_one({
                    "id": u.id,
                    "name": u.name,
                    "monthlyIncome": u.monthlyIncome,
                    "numberOfStudent": u.numberOfStudent
                })
                messagebox.showinfo("Éxito", "Universidad insertada correctamente")
                self.mostrar_insertar()
            except Exception as e:
                messagebox.showerror("Error", f"Datos inválidos: {e}")

        tk.Button(self.frame_principal, text="Guardar", command=guardar).pack(pady=10)

    def mostrar_calcular(self):
        self.limpiar_frame_principal()

        universidades = self.mongo.get_universities()

        # Tabla con cálculo
        cols = ("Nombre", "Ingreso mensual", "Estudiantes", "Ingreso por estudiante")
        tabla = ttk.Treeview(self.frame_principal, columns=cols, show="headings")
        for col in cols:
            tabla.heading(col, text=col)
        tabla.pack()

        for u in universidades:
            ub = UniversityBusiness(u)
            tabla.insert("", "end", values=(
                u.name,
                u.monthlyIncome,
                u.numberOfStudent,
                f"{ub.income_per_student():.2f}"
            ))