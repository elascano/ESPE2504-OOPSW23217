import tkinter as tk
from tkinter import ttk, messagebox
from pymongo import MongoClient

class MixerWindow:
    CURRENCY_RATES = {
        "USD": 1.0,
        "EUR": 0.92,
        "MXN": 18.94,
        "JPY": 145.0
    }

    def __init__(self, master):
        self.master = master
        master.title("Sound Mixer Manager")

        self.client = MongoClient("mongodb+srv://Gerald:Gerald@cluster0.ii5j1oo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
        self.db = self.client["POO"]
        self.collection = self.db["SoundMixerDb"]

        tk.Label(master, text="Brand:").grid(row=0, column=0, sticky="e")
        self.brand_entry = tk.Entry(master)
        self.brand_entry.grid(row=0, column=1)

        tk.Label(master, text="Model:").grid(row=1, column=0, sticky="e")
        self.model_entry = tk.Entry(master)
        self.model_entry.grid(row=1, column=1)

        tk.Label(master, text="Type:").grid(row=2, column=0, sticky="e")
        self.type_var = tk.StringVar()
        self.type_combo = ttk.Combobox(master, textvariable=self.type_var, values=["Analogico", "Digital"], state="readonly")
        self.type_combo.grid(row=2, column=1)
        self.type_combo.current(0)

        tk.Label(master, text="Number of Channels:").grid(row=3, column=0, sticky="e")
        self.channels_entry = tk.Entry(master)
        self.channels_entry.grid(row=3, column=1)

        tk.Label(master, text="Price:").grid(row=4, column=0, sticky="e")
        self.price_entry = tk.Entry(master)
        self.price_entry.grid(row=4, column=1, sticky="w")

        self.currency_var = tk.StringVar(value="USD")
        self.currency_combo = ttk.Combobox(master, textvariable=self.currency_var, values=["USD", "EUR", "MXN", "JPY"], state="readonly", width=7)
        self.currency_combo.grid(row=4, column=2, padx=5, sticky="w")
        self.currency_combo.bind("<<ComboboxSelected>>", self.on_currency_change)

        tk.Label(master, text="Serial Number:").grid(row=5, column=0, sticky="e")
        self.serial_entry = tk.Entry(master)
        self.serial_entry.grid(row=5, column=1)

        button_frame = tk.Frame(master)
        button_frame.grid(row=6, column=0, columnspan=3, pady=15)

        self.upload_btn = tk.Button(button_frame, text="Subir", width=12, command=self.upload)
        self.upload_btn.pack(side=tk.LEFT, padx=5)

        self.search_btn = tk.Button(button_frame, text="Buscar", width=12, command=self.search)
        self.search_btn.pack(side=tk.LEFT, padx=5)

        self.update_btn = tk.Button(button_frame, text="Actualizar", width=12, command=self.update)
        self.update_btn.pack(side=tk.LEFT, padx=5)

        self.delete_btn = tk.Button(button_frame, text="Eliminar", width=12, command=self.delete)
        self.delete_btn.pack(side=tk.LEFT, padx=5)

        self.usd_price = None

    def on_currency_change(self, event=None):
        try:
            if self.usd_price is None or self.usd_price == 0.0:
                current_currency = self.currency_var.get()
                price_str = self.price_entry.get()
                if not price_str:
                    return
                price = float(price_str)
                rate = self.CURRENCY_RATES.get(current_currency, 1.0)
                self.usd_price = price / rate if rate != 0 else price

            selected_currency = self.currency_var.get()
            rate = self.CURRENCY_RATES.get(selected_currency, 1.0)
            converted = self.usd_price * rate
            self.price_entry.delete(0, tk.END)
            self.price_entry.insert(0, f"{converted:.2f}")
        except Exception:
            pass  
    def upload(self):
        try:
            brand = self.brand_entry.get()
            model = self.model_entry.get()
            is_digital = True if self.type_var.get() == "Digital" else False
            num_channels = int(self.channels_entry.get())
            serial_number = self.serial_entry.get()

            if self.usd_price is not None:
                price = float(self.usd_price)
            else:
                current_currency = self.currency_var.get()
                price = float(self.price_entry.get())
                rate = self.CURRENCY_RATES.get(current_currency, 1.0)
                price = price / rate if rate != 0 else price

            if not (brand and model and serial_number):
                messagebox.showerror("Error", "Todos los campos son obligatorios.")
                return

            if self.collection.find_one({"serialNumber": serial_number}):
                messagebox.showerror("Error", "Ya existe un sound mixer con ese número de serie.")
                return

            doc = {
                "brand": brand,
                "model": model,
                "isDigital": is_digital,
                "numChannels": num_channels,
                "price": price,
                "serialNumber": serial_number
            }
            self.collection.insert_one(doc)
            messagebox.showinfo("Éxito", "Sound mixer subido correctamente.")
        except Exception as e:
            messagebox.showerror("Error", f"Datos inválidos o error en la base de datos.\n{e}")

    def search(self):
        serial_number = self.serial_entry.get()
        if not serial_number:
            messagebox.showerror("Error", "Ingrese el número de serie para buscar.")
            return
        mixer = self.collection.find_one({"serialNumber": serial_number})
        if mixer:
            self.brand_entry.delete(0, tk.END)
            self.brand_entry.insert(0, mixer["brand"])
            self.model_entry.delete(0, tk.END)
            self.model_entry.insert(0, mixer["model"])
            self.type_combo.set("Digital" if mixer["isDigital"] else "Analogico")
            self.channels_entry.delete(0, tk.END)
            self.channels_entry.insert(0, str(mixer["numChannels"]))
            self.usd_price = float(mixer["price"])
            self.currency_var.set("USD")
            self.price_entry.delete(0, tk.END)
            self.price_entry.insert(0, f"{self.usd_price:.2f}")
            messagebox.showinfo("Encontrado", "Sound mixer encontrado y cargado en la interfaz.")
        else:
            messagebox.showinfo("No encontrado", "No existe un sound mixer con ese número de serie.")

    def delete(self):
        serial_number = self.serial_entry.get()
        if not serial_number:
            messagebox.showerror("Error", "Ingrese el número de serie para eliminar.")
            return
        mixer = self.collection.find_one({"serialNumber": serial_number})
        if not mixer:
            messagebox.showerror("Error", "Debe buscar primero el sound mixer antes de eliminar.")
            return
        self.collection.delete_one({"serialNumber": serial_number})
        messagebox.showinfo("Eliminado", "Sound mixer eliminado correctamente.")
        self.clear_fields()

    def update(self):
        serial_number = self.serial_entry.get()
        if not serial_number:
            messagebox.showerror("Error", "Ingrese el número de serie para actualizar.")
            return

        mixer = self.collection.find_one({"serialNumber": serial_number})
        if not mixer:
            messagebox.showerror("Error", "Debe buscar primero el sound mixer antes de actualizar.")
            return

        try:
            brand = self.brand_entry.get()
            model = self.model_entry.get()
            is_digital = True if self.type_var.get() == "Digital" else False
            num_channels = int(self.channels_entry.get())

            if self.usd_price is not None:
                price = float(self.usd_price)
            else:
                current_currency = self.currency_var.get()
                price = float(self.price_entry.get())
                rate = self.CURRENCY_RATES.get(current_currency, 1.0)
                price = price / rate if rate != 0 else price

            if not (brand and model and serial_number):
                messagebox.showerror("Error", "Todos los campos son obligatorios.")
                return

            update_doc = {
                "brand": brand,
                "model": model,
                "isDigital": is_digital,
                "numChannels": num_channels,
                "price": price,
                "serialNumber": serial_number
            }

            self.collection.update_one(
                {"serialNumber": serial_number},
                {"$set": update_doc}
            )
            messagebox.showinfo("Actualizado", "Sound mixer actualizado correctamente.")
        except Exception as e:
            messagebox.showerror("Error", f"Datos inválidos o error en la base de datos.\n{e}")

    def clear_fields(self):
        self.brand_entry.delete(0, tk.END)
        self.model_entry.delete(0, tk.END)
        self.type_combo.set("Analogico")
        self.channels_entry.delete(0, tk.END)
        self.price_entry.delete(0, tk.END)
        self.serial_entry.delete(0, tk.END)
        self.currency_var.set("USD")
        self.usd_price = None

if __name__ == "__main__":
    root = tk.Tk()
    app = MixerWindow(root)
    root.mainloop()