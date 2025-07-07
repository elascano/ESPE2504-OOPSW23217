import tkinter as tk
from tkinter import ttk, messagebox
from bson.objectid import ObjectId
from db_connection import DatabaseConnection

class SoundMixerCrudMenu(tk.Toplevel):
    def __init__(self, db_connection, user_id):
        super().__init__()
        self.title("Gestión de SoundMixers")
        self.geometry("1000x400")
        self.db_connection = db_connection
        self.user_id = user_id

        self.grid_rowconfigure(0, weight=1)
        self.grid_columnconfigure(0, weight=1)

        self.tree = ttk.Treeview(self, columns=("brand", "model", "isDigital", "numChannels", "price", "serialNumber"), show="headings")
        for col in self.tree["columns"]:
            self.tree.heading(col, text=col)
            self.tree.column(col, width=150, anchor="center")
        self.tree.grid(row=0, column=0, sticky="nsew", padx=6, pady=6)


        btn_frame = ttk.Frame(self)
        btn_frame.grid(row=1, column=0, pady=10, sticky="ew")
        btn_frame.grid_columnconfigure((0,1,2,3), weight=1)
        ttk.Button(btn_frame, text="Crear", command=self.create_mixer).pack(side=tk.LEFT, padx=5)
        ttk.Button(btn_frame, text="Editar", command=self.edit_mixer).pack(side=tk.LEFT, padx=5)
        ttk.Button(btn_frame, text="Eliminar", command=self.delete_mixer).pack(side=tk.LEFT, padx=5)
        ttk.Button(btn_frame, text="Refrescar", command=self.load_mixers).pack(side=tk.LEFT, padx=5)

        self.load_mixers()

    def load_mixers(self):
        for row in self.tree.get_children():
            self.tree.delete(row)
        mixers = self.db_connection.get_sound_mixer_data(self.user_id)
        for mixer in mixers:
            self.tree.insert("", tk.END, iid=mixer["_id"], values=(
                mixer["brand"], mixer["model"], mixer["isDigital"], mixer["numChannels"], mixer["price"], mixer["serialNumber"]
            ))

    def create_mixer(self):
        def on_create(data):
            data["user_id"] = ObjectId(self.user_id) if isinstance(self.user_id, str) else self.user_id
            self.db_connection.sound_mixer_collection.insert_one(data)
            self.load_mixers()
        SoundMixerMenu(on_create)

    def create_mixer(self):
        from soundmixer_menu import SoundMixerMenu  # Importación local
        def on_create(data):
            data["user_id"] = ObjectId(self.user_id) if isinstance(self.user_id, str) else self.user_id
            self.db_connection.sound_mixer_collection.insert_one(data)
            self.load_mixers()
        SoundMixerMenu(on_create)

    def edit_mixer(self):
        from soundmixer_menu import SoundMixerMenu  # Importación local para evitar el ciclo
        selected = self.tree.selection()
        if not selected:
            messagebox.showwarning("Selecciona", "Selecciona un SoundMixer para editar.")
            return
        mixer_id = selected[0]
        mixer = self.db_connection.sound_mixer_collection.find_one({"_id": ObjectId(mixer_id)})
        if not mixer:
            messagebox.showerror("Error", "No se encontró el SoundMixer.")
            return

        def on_update(data):
            self.db_connection.sound_mixer_collection.update_one(
                {"_id": ObjectId(mixer_id)},
                {"$set": data}
            )
            self.load_mixers()
        win = SoundMixerMenu(on_update)
        win.entries["brand"].insert(0, mixer["brand"])
        win.entries["model"].insert(0, mixer["model"])
        win.entries["isDigital"].set(mixer["isDigital"])
        win.entries["numChannels"].insert(0, mixer["numChannels"])
        win.entries["price"].insert(0, mixer["price"])
        win.entries["serialNumber"].insert(0, mixer["serialNumber"])

    def delete_mixer(self):
        selected = self.tree.selection()
        if not selected:
            messagebox.showwarning("Selecciona", "Selecciona un SoundMixer para eliminar.")
            return
        mixer_id = selected[0]
        if messagebox.askyesno("Confirmar", "¿Seguro que deseas eliminar este SoundMixer?"):
            self.db_connection.sound_mixer_collection.delete_one({"_id": ObjectId(mixer_id)})
            self.load_mixers()