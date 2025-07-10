import tkinter as tk
from tkinter import ttk, messagebox
from pymongo import MongoClient
from pymongo.errors import ConnectionFailure


try:
    uri = "mongodb+srv://isaac:isaac@cluster0.xaitfht.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
  
    client = MongoClient(uri, serverSelectionTimeoutMS=5000)
    client.admin.command("ping")
    print(" Successfully connected to MongoDB Atlas.")
    db = client["University"]
    collection = db["university"]
except ConnectionFailure as e:
    print(" Could not connect to MongoDB Atlas:", e)
    exit()

class MainMenu:
    def __init__(self, root):
        self.root = root
        self.root.title("Main Menu - University")
        self.root.geometry("300x200")

        lbl_title = tk.Label(root, text="Main Menu", font=("Helvetica", 16))
        lbl_title.pack(pady=20)

        btn_list = tk.Button(root, text="List Universities", width=25, command=self.open_list_window)
        btn_list.pack(pady=10)

        btn_calculate = tk.Button(root, text="Calculate ", width=25, command=self.calculate)
        btn_calculate.pack(pady=10)

    def open_list_window(self):
        list_window = tk.Toplevel(self.root)
        UniversityList(list_window)

    def calculate(self):
        messagebox.showinfo("Calculate.")

class UniversityList:
    def __init__(self, root):
        self.root = root
        self.root.title("List of Universities")
        self.root.geometry("500x400")

        columns = ("ID", "Name", "Monthly Income")
        self.tree = ttk.Treeview(root, columns=columns, show="headings")
        for col in columns:
            self.tree.heading(col, text=col)
            self.tree.column(col, anchor="center")
        self.tree.pack(fill="both", expand=True, pady=10)

        self.load_universities()

    def load_universities(self):
        # Clear the table first
        for item in self.tree.get_children():
            self.tree.delete(item)

        try:
            universities = collection.find().sort("ID", 1)
            found_any = False

            for u in universities:
                id_value = u.get("ID", 0)
                name_value = u.get("name", "")
                income_value = u.get("monthlyIncome", 0.0)

                self.tree.insert("", "end", values=(id_value, name_value, income_value))
                found_any = True

            if not found_any:
                messagebox.showinfo("Info", "No universities found in the database.")

        except Exception as e:
            messagebox.showerror("Error", f"Error loading universities: {e}")

if __name__ == "__main__":
    root = tk.Tk()
    app = MainMenu(root)
    root.mainloop()
