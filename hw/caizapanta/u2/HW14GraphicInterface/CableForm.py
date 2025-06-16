import tkinter as tk
from tkinter import messagebox
import pymongo

# === MongoDB Atlas connection ===
client = pymongo.MongoClient("mongodb+srv://tacaizapanta:tacaizapanta@cluster0.ircnkvg.mongodb.net/")
db = client["CableDB"]
collection = db["cables"]

# === Price calculation ===
def calculate_total(length, price_per_meter):
    return round(length * price_per_meter, 2)

# === Generate next ID in format 001, 002, 003... ===
def get_next_id():
    last_cable = collection.find_one(sort=[("id", -1)])
    if last_cable and last_cable["id"].isdigit():
        next_id = int(last_cable["id"]) + 1
    else:
        next_id = 1
    return f"{next_id:03d}"

# === CRUD functions ===

def create_cable():
    cable_type = entry_type.get().strip()
    brand = entry_brand.get().strip()
    length_str = entry_length.get().strip()
    price_str = entry_price.get().strip()

    if not cable_type or not brand or not length_str or not price_str:
        messagebox.showerror("Error", "All required fields must be filled.")
        return

    try:
        length = float(length_str)
        price = float(price_str)
    except ValueError:
        messagebox.showerror("Error", "Invalid number in length or price.")
        return

    total_price = calculate_total(length, price)
    new_id = get_next_id()

    cable = {
        "id": new_id,
        "type": cable_type,
        "brand": brand,
        "lengthMeters": length,
        "pricePerMeter": price,
        "totalPrice": total_price
    }

    collection.insert_one(cable)
    messagebox.showinfo("Success", f"Cable created successfully with ID: {new_id}!")
    result_label.config(text=f"💲 Total Price: ${total_price:.2f}")
    id_label.config(text=f"🆔 ID: {new_id}")
    clear_fields(keep_search=True)

def read_cable():
    cable_type = entry_type.get().strip()
    if not cable_type:
        messagebox.showerror("Error", "Enter the cable type to search.")
        return

    cable = collection.find_one({"type": cable_type})
    if cable:
        entry_id.delete(0, tk.END)
        entry_brand.delete(0, tk.END)
        entry_length.delete(0, tk.END)
        entry_price.delete(0, tk.END)

        entry_id.insert(0, cable["id"])
        entry_brand.insert(0, cable.get("brand", ""))
        entry_length.insert(0, cable["lengthMeters"])
        entry_price.insert(0, cable["pricePerMeter"])

        result_label.config(text=f"💲 Total Price: ${cable['totalPrice']:.2f}")
        id_label.config(text=f"🆔 ID: {cable['id']}")
    else:
        messagebox.showinfo("Not found", "Cable not found.")
        clear_fields()

def update_cable():
    cable_type = entry_type.get().strip()
    brand = entry_brand.get().strip()
    if not cable_type or not brand:
        messagebox.showerror("Error", "Enter the cable type and brand to update.")
        return

    try:
        length = float(entry_length.get().strip())
        price = float(entry_price.get().strip())
    except ValueError:
        messagebox.showerror("Error", "Invalid input for numbers.")
        return

    total_price = calculate_total(length, price)

    updated = collection.update_one(
        {"type": cable_type},
        {"$set": {
            "brand": brand,
            "lengthMeters": length,
            "pricePerMeter": price,
            "totalPrice": total_price
        }}
    )

    if updated.matched_count:
        messagebox.showinfo("Success", "Cable updated successfully!")
        result_label.config(text=f"💲 Total Price: ${total_price:.2f}")
    else:
        messagebox.showwarning("Warning", "Cable not found.")
    clear_fields()

def delete_cable():
    cable_type = entry_type.get().strip()
    if not cable_type:
        messagebox.showerror("Error", "Enter the cable type to delete.")
        return

    deleted = collection.delete_one({"type": cable_type})
    if deleted.deleted_count:
        messagebox.showinfo("Deleted", "Cable deleted.")
        result_label.config(text="📝 Result:")
        id_label.config(text="🆔 ID:")
    else:
        messagebox.showwarning("Not found", "Cable not found.")
    clear_fields()

def search_by_id():
    code = entry_id.get().strip()
    if not code:
        messagebox.showerror("Error", "Enter the cable ID to search.")
        return

    cable = collection.find_one({"id": code})
    if cable:
        entry_type.delete(0, tk.END)
        entry_brand.delete(0, tk.END)
        entry_length.delete(0, tk.END)
        entry_price.delete(0, tk.END)

        entry_type.insert(0, cable["type"])
        entry_brand.insert(0, cable.get("brand", ""))
        entry_length.insert(0, cable["lengthMeters"])
        entry_price.insert(0, cable["pricePerMeter"])

        result_label.config(text=f"💲 Total Price: ${cable['totalPrice']:.2f}")
        id_label.config(text=f"🆔 ID: {cable['id']}")
    else:
        messagebox.showinfo("Not found", "Cable not found.")
        clear_fields()

def clear_fields(keep_search=False):
    if not keep_search:
        entry_type.delete(0, tk.END)
        entry_brand.delete(0, tk.END)
        entry_id.delete(0, tk.END)
    entry_length.delete(0, tk.END)
    entry_price.delete(0, tk.END)
    if not keep_search:
        result_label.config(text="📝 Result:")
        id_label.config(text="🆔 ID:")

# === GUI ===
window = tk.Tk()
window.title("⚙️ Cable CRUD - MongoDB Atlas with Brand and ID Search")
window.geometry("480x480")
window.resizable(False, False)

label_font = ("Segoe UI", 10)
entry_width = 35

tk.Label(window, text="Cable Registration Form", font=("Segoe UI", 13, "bold")).pack(pady=10)

form_frame = tk.Frame(window)
form_frame.pack(pady=5)

# Search by ID field (arriba)
tk.Label(form_frame, text="Search by ID", font=label_font).grid(row=0, column=0, sticky="w")
entry_id = tk.Entry(form_frame, width=entry_width)
entry_id.grid(row=0, column=1, pady=6)
tk.Button(form_frame, text="Search", command=search_by_id, width=10).grid(row=0, column=2, padx=5)

# Input fields below
tk.Label(form_frame, text="Type *", font=label_font).grid(row=1, column=0, sticky="w")
entry_type = tk.Entry(form_frame, width=entry_width)
entry_type.grid(row=1, column=1, pady=6)

tk.Label(form_frame, text="Brand *", font=label_font).grid(row=2, column=0, sticky="w")
entry_brand = tk.Entry(form_frame, width=entry_width)
entry_brand.grid(row=2, column=1, pady=6)

tk.Label(form_frame, text="Length (m) *", font=label_font).grid(row=3, column=0, sticky="w")
entry_length = tk.Entry(form_frame, width=entry_width)
entry_length.grid(row=3, column=1, pady=6)

tk.Label(form_frame, text="Price per meter *", font=label_font).grid(row=4, column=0, sticky="w")
entry_price = tk.Entry(form_frame, width=entry_width)
entry_price.grid(row=4, column=1, pady=6)

# Result and ID Labels
result_label = tk.Label(window, text="📝 Result:", font=("Segoe UI", 10, "italic"))
result_label.pack(pady=8)

id_label = tk.Label(window, text="🆔 ID:", font=("Segoe UI", 10, "italic"))
id_label.pack(pady=4)

# Buttons
btn_frame = tk.Frame(window)
btn_frame.pack(pady=8)

tk.Button(btn_frame, text="Create", command=create_cable, width=15).grid(row=0, column=0, padx=8, pady=4)
tk.Button(btn_frame, text="Read", command=read_cable, width=15).grid(row=0, column=1, padx=8, pady=4)
tk.Button(btn_frame, text="Update", command=update_cable, width=15).grid(row=1, column=0, padx=8, pady=4)
tk.Button(btn_frame, text="Delete", command=delete_cable, width=15).grid(row=1, column=1, padx=8, pady=4)

window.mainloop()
