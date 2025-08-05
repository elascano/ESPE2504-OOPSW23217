import tkinter as tk
from tkinter import messagebox
from mongoDBConection import getCollection

def createCalculationsTab(notebook):
    frame = tk.Frame(notebook)
    collection = getCollection()

    priceVar = tk.StringVar()
    discountVar = tk.StringVar()
    gbVar = tk.StringVar()
    mgVar = tk.StringVar()
    resultVar = tk.StringVar()

    def calcDiscount():
        try:
            price = float(priceVar.get())
            discount = float(discountVar.get())
            final = round(price * (1 - discount/100), 2)
            resultVar.set(f"Final price after discount: ${final}")
        except:
            messagebox.showerror("Error", "Invalid price or discount")

    def gbToMg():
        try:
            gb = float(gbVar.get())
            mg = gb * 1024
            resultVar.set(f"{gb} GB = {mg} MB")
        except:
            messagebox.showerror("Error", "Invalid GB value")

    def mgToGb():
        try:
            mg = float(mgVar.get())
            gb = mg / 1024
            resultVar.set(f"{mg} MB = {round(gb, 4)} GB")
        except:
            messagebox.showerror("Error", "Invalid MB value")

    tk.Label(frame, text="Discount calculator", font=("Arial", 14)).grid(row=0, column=0, columnspan=3, pady=10)

    tk.Label(frame, text="Price ($):").grid(row=1, column=0, sticky="e")
    tk.Entry(frame, textvariable=priceVar).grid(row=1, column=1)
    tk.Label(frame, text="Discount (%):").grid(row=2, column=0, sticky="e")
    tk.Entry(frame, textvariable=discountVar).grid(row=2, column=1)
    tk.Button(frame, text="Calculate Discount", command=calcDiscount).grid(row=3, column=0, columnspan=2, pady=5)

    tk.Label(frame, text="Convert GB to MB").grid(row=4, column=0, columnspan=2, pady=10)
    tk.Entry(frame, textvariable=gbVar).grid(row=5, column=0)
    tk.Button(frame, text="Convert GB → MB", command=gbToMg).grid(row=5, column=1)

    tk.Label(frame, text="Convert MB to GB").grid(row=6, column=0, columnspan=2, pady=10)
    tk.Entry(frame, textvariable=mgVar).grid(row=7, column=0)
    tk.Button(frame, text="Convert MB → GB", command=mgToGb).grid(row=7, column=1)

    tk.Label(frame, textvariable=resultVar, fg="blue", font=("Arial", 12)).grid(row=8, column=0, columnspan=2, pady=15)

    return frame
