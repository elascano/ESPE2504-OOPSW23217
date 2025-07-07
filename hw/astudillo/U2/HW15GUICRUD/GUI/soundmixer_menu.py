import tkinter as tk
from tkinter import ttk
from soundmixer_crud_menu import SoundMixerCrudMenu
from db_connection import DatabaseConnection

class SoundMixerMenu(tk.Toplevel):
    def __init__(self, on_create_callback, user_id=None):
        super().__init__()
        self.title("Crear SoundMixer")
        self.geometry("350x400")
        self.resizable(False, False)
        self.user_id = user_id

        vcmd_int = (self.register(self._validate_int), "%P")
        vcmd_float = (self.register(self._validate_float), "%P")

        labels = [
            ("Marca:", "brand"),
            ("Modelo:", "model"),
            ("¿Es digital?", "isDigital"),
            ("Nº de canales:", "numChannels"),
            ("Precio:", "price"),
            ("Nº de serie:", "serialNumber")
        ]
        self.entries = {}

        for idx, (label_text, key) in enumerate(labels):
            ttk.Label(self, text=label_text).grid(row=idx, column=0, padx=10, pady=8, sticky="w")
            if key == "isDigital":
                self.entries[key] = tk.BooleanVar()
                ttk.Checkbutton(self, variable=self.entries[key]).grid(row=idx, column=1, sticky="w")
            elif key == "numChannels":
                entry = ttk.Entry(self, validate="key", validatecommand=vcmd_int)
                entry.grid(row=idx, column=1, padx=10)
                self.entries[key] = entry
            elif key == "price":
                entry = ttk.Entry(self, validate="key", validatecommand=vcmd_float)
                entry.grid(row=idx, column=1, padx=10)
                self.entries[key] = entry
            else:
                entry = ttk.Entry(self)
                entry.grid(row=idx, column=1, padx=10)
                self.entries[key] = entry

        self.create_button = ttk.Button(self, text="Crear", command=self._on_create)
        self.create_button.grid(row=len(labels), column=0, columnspan=2, pady=10)

        # Botón para abrir el menú CRUD
        self.crud_button = ttk.Button(self, text="Ver/Editar SoundMixers", command=self.open_crud_menu)
        self.crud_button.grid(row=len(labels)+1, column=0, columnspan=2, pady=5)

        self.on_create_callback = on_create_callback

    def open_crud_menu(self):
        db_connection = DatabaseConnection()
        SoundMixerCrudMenu(db_connection, self.user_id)
        self.destroy()

    def _validate_int(self, value):
        return value.isdigit() or value == ""

    def _validate_float(self, value):
        if value == "":
            return True
        try:
            float(value)
            return True
        except ValueError:
            return False

    def _on_create(self):
        for key in ["brand", "model", "numChannels", "price", "serialNumber"]:
            value = self.entries[key].get() if key != "isDigital" else self.entries[key].get()
            if value == "" or value is None:
                tk.messagebox.showwarning("Campos vacíos", "Por favor, complete todos los campos.")
                return

        try:
            num_channels = int(self.entries["numChannels"].get())
        except ValueError:
            tk.messagebox.showerror("Error", "El número de canales debe ser un número entero.")
            return

        try:
            price = float(self.entries["price"].get())
        except ValueError:
            tk.messagebox.showerror("Error", "El precio debe ser un número.")
            return

        data = {
            "brand": self.entries["brand"].get(),
            "model": self.entries["model"].get(),
            "isDigital": self.entries["isDigital"].get(),
            "numChannels": num_channels,
            "price": price,
            "serialNumber": self.entries["serialNumber"].get()
        }
        self.on_create_callback(data)
        pass