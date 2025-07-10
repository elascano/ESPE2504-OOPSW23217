import tkinter as tk
from tkinter import messagebox, simpledialog
from pymongo import MongoClient

connectionString = "mongodb+srv://esteban474sanchez:Yesteb@cluster0.rpbnucr.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

def get_collection():
    client = MongoClient(connectionString)
    db = client["Homework"]
    return db["Potatoes"]  

# ---------- CRUD Functions ----------
def insert_potato():
    try:
        id = int(entry_id.get())
        stock = int(entry_stock.get())
        price = float(entry_price.get().replace(',', '.'))

        col = get_collection()
        if col.find_one({"id": id}):
            messagebox.showerror("Error", f"A potato with ID {id} already exists")
            return

        col.insert_one({
            "id": id, "stock": stock, "price": price
        })
        messagebox.showinfo("Success", "Potato inserted successfully")
        clear_fields()
    except Exception as e:
        messagebox.showerror("Error", str(e))

def list_potatoes():
    try:
        col = get_collection()
        text_output.delete("1.0", tk.END)
        for potato in col.find():
            text_output.insert(tk.END, f"{potato}\n")
    except Exception as e:
        messagebox.showerror("Error", str(e))

def update_potato():
    try:
        id = int(entry_id.get())
        stock = int(entry_stock.get())
        price = float(entry_price.get().replace(',', '.'))

        col = get_collection()
        result = col.update_one({"id": id}, {"$set": {"stock": stock, "price": price}})
        if result.matched_count:
            messagebox.showinfo("Updated", "Potato updated successfully")
        else:
            messagebox.showwarning("Not found", "No potato found with that ID")
    except Exception as e:
        messagebox.showerror("Error", str(e))

def delete_potato():
    try:
        id = int(entry_id.get())
        col = get_collection()
        result = col.delete_one({"id": id})
        if result.deleted_count:
            messagebox.showinfo("Deleted", "Potato deleted successfully")
        else:
            messagebox.showwarning("Not found", "No potato found with that ID")
    except Exception as e:
        messagebox.showerror("Error", str(e))

# ---------- Purchase Function ----------
def purchase_potato():
    try:
        col = get_collection()
        list_potatoes()
        id = int(simpledialog.askstring("Purchase", "Enter the ID of the potato to purchase:"))
        quantity = int(simpledialog.askstring("Purchase", "Enter quantity to purchase:"))

        potato = col.find_one({"id": id})
        if not potato:
            messagebox.showwarning("Not found", "Potato not found")
            return

        stock = potato["stock"]
        price = potato["price"]

        if quantity > stock:
            messagebox.showerror("Out of stock", "Not enough stock available")
            return

        total = price * quantity
        if total > 20:
            total *= 0.90
            discount = "10%"
        elif total > 5:
            total *= 0.95
            discount = "5%"
        else:
            discount = "0%"

        col.update_one({"id": id}, {"$inc": {"stock": -quantity}})

        messagebox.showinfo("Purchase Successful",
            f"Purchased {quantity} potatoes\n"
            f"Discount applied: {discount}\n"
            f"Total to pay: {round(total, 2)}")
    except Exception as e:
        messagebox.showerror("Error", str(e))

# ---------- GUI ----------
def clear_fields():
    entry_id.delete(0, tk.END)
    entry_stock.delete(0, tk.END)
    entry_price.delete(0, tk.END)

root = tk.Tk()
root.title("Potato Inventory Manager")
root.geometry("500x600")

# ---------- Input Fields ----------
labels = ["ID", "Stock", "Price"]
entries = []

for i, text in enumerate(labels):
    tk.Label(root, text=text).grid(row=i, column=0, sticky="e")
    entry = tk.Entry(root)
    entry.grid(row=i, column=1, padx=5, pady=5)
    entries.append(entry)

entry_id, entry_stock, entry_price = entries

# ---------- Buttons ----------
tk.Button(root, text="Insert", command=insert_potato, width=20).grid(row=3, column=0, pady=10)
tk.Button(root, text="List", command=list_potatoes, width=20).grid(row=3, column=1)
tk.Button(root, text="Update", command=update_potato, width=20).grid(row=4, column=0)
tk.Button(root, text="Delete", command=delete_potato, width=20).grid(row=4, column=1)
tk.Button(root, text="Purchase Potato", command=purchase_potato, width=42).grid(row=5, column=0, columnspan=2, pady=10)

# ---------- Output Text ----------
tk.Label(root, text="Potato List:").grid(row=6, column=0, columnspan=2)
text_output = tk.Text(root, height=20, width=60)
text_output.grid(row=7, column=0, columnspan=2, padx=10, pady=5)

root.mainloop()
