import tkinter as tk
from tkinter import ttk, messagebox
from bson.objectid import ObjectId
from mongoDBConection import getCollection

def createCrudTab(notebook):
    frame = tk.Frame(notebook)
    collection = getCollection()

    varsDict = {
        "brand": tk.StringVar(),
        "capacityGB": tk.StringVar(),
        "price": tk.StringVar(),
        "color": tk.StringVar(),
        "usbType": tk.StringVar(),
        "stock": tk.StringVar(),
        "warrantyMonths": tk.StringVar(),
        "discountPercentage": tk.StringVar(),
    }

    selectedId = [None]

    def calcFinalPrice(price, discount):
        try:
            p = float(price)
            d = float(discount)
            return round(p * (1 - d / 100), 2)
        except:
            return 0.0

    def clearEntries():
        for var in varsDict.values():
            var.set("")
        selectedId[0] = None

    def loadData():
        for item in tree.get_children():
            tree.delete(item)
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
                doc.get("finalPrice", ""),
            ))

    def onSelect(event):
        selected = tree.focus()
        if not selected:
            return
        selectedId[0] = selected
        values = tree.item(selected)["values"]
        keys = list(varsDict.keys())
        for i, key in enumerate(keys):
            varsDict[key].set(values[i])

    def addItem():
        try:
            data = {k: varsDict[k].get() for k in varsDict}
            data["capacityGB"] = int(data["capacityGB"])
            data["price"] = float(data["price"])
            data["stock"] = int(data["stock"])
            data["warrantyMonths"] = int(data["warrantyMonths"])
            data["discountPercentage"] = float(data["discountPercentage"])
            data["finalPrice"] = calcFinalPrice(data["price"], data["discountPercentage"])

            collection.insert_one(data)
            loadData()
            clearEntries()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def updateItem():
        if selectedId[0] is None:
            messagebox.showwarning("Warning", "Select a record first")
            return
        try:
            data = {k: varsDict[k].get() for k in varsDict}
            data["capacityGB"] = int(data["capacityGB"])
            data["price"] = float(data["price"])
            data["stock"] = int(data["stock"])
            data["warrantyMonths"] = int(data["warrantyMonths"])
            data["discountPercentage"] = float(data["discountPercentage"])
            data["finalPrice"] = calcFinalPrice(data["price"], data["discountPercentage"])

            collection.update_one({"_id": ObjectId(selectedId[0])}, {"$set": data})
            loadData()
            clearEntries()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def deleteItem():
        if selectedId[0] is None:
            messagebox.showwarning("Warning", "Select a record first")
            return
        collection.delete_one({"_id": ObjectId(selectedId[0])})
        loadData()
        clearEntries()

    labels = ["Brand", "Capacity (GB)", "Price", "Color", "USB Type", "Stock", "Warranty (Months)", "Discount (%)"]
    for i, label in enumerate(labels):
        tk.Label(frame, text=label).grid(row=i, column=0, sticky="e", padx=5, pady=3)
        tk.Entry(frame, textvariable=varsDict[label.replace(" ", "").replace("(GB)", "GB").replace("(%)", "Percentage").lower()]).grid(row=i, column=1, padx=5, pady=3)

    tk.Button(frame, text="Add", command=addItem).grid(row=0, column=2, padx=5)
    tk.Button(frame, text="Update", command=updateItem).grid(row=1, column=2, padx=5)
    tk.Button(frame, text="Delete", command=deleteItem).grid(row=2, column=2, padx=5)
    tk.Button(frame, text="Clear", command=clearEntries).grid(row=3, column=2, padx=5)

    cols = ["Brand", "CapacityGB", "Price", "Color", "USB Type", "Stock", "WarrantyMonths", "DiscountPercentage", "Final Price"]
    tree = ttk.Treeview(frame, columns=cols, show="headings", height=12)
    for c in cols:
        tree.heading(c, text=c)
        tree.column(c, width=90)
    tree.grid(row=9, column=0, columnspan=3, pady=10, padx=10)
    tree.bind("<<TreeviewSelect>>", onSelect)

    loadData()
    return frame
