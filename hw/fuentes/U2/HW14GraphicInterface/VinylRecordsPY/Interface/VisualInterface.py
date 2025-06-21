import tkinter as tk
from tkinter import messagebox
from model.VinylRecord import VinylRecord
from DataBase.MongoConnection import connect_to_mongo


class VinylApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Vinyl Record Registration")
        self.entries = {}

        fields = [
            "Title", "Artist", "Year", "Gender", "Duration",
            "Label", "Country", "Color", "Price"
        ]

        for i, field in enumerate(fields):
            label = tk.Label(root, text=field + ":")
            label.grid(row=i, column=0, sticky="e", padx=5, pady=5)
            entry = tk.Entry(root)
            entry.grid(row=i, column=1, padx=5, pady=5)
            self.entries[field.lower()] = entry

        tk.Label(root, text="Limited Edition (Y/N):").grid(row=9, column=0, sticky="e", padx=5, pady=5)
        self.limited_var = tk.StringVar()
        self.limited_dropdown = tk.OptionMenu(root, self.limited_var, "Y", "N")
        self.limited_dropdown.grid(row=9, column=1, padx=5, pady=5)
        self.limited_var.set("N")

        self.save_button = tk.Button(root, text="Save", command=self.save_record)
        self.save_button.grid(row=10, columnspan=2, pady=10)

        self.collection = connect_to_mongo()

    def save_record(self):
        try:
            data = {k: v.get() for k, v in self.entries.items()}
            data["limited_edition"] = self.limited_var.get()

            record = VinylRecord(**data)
            self.collection.insert_one(record.to_document())

            messagebox.showinfo("Success", "Record saved successfully!")

            for entry in self.entries.values():
                entry.delete(0, tk.END)

        except Exception as e:
            messagebox.showerror("Error", f"Failed to save record: {e}")
