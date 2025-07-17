import tkinter as tk
from tkinter import ttk

class Playerview:
    def __init__(self, root, controller):
        self.controller = controller
        self.root = root
        self.root.title("Soccer Players Viewer")

        columns = ("id", "name", "lastname", "basesalary", "bono", "finalsalary")
        self.tree = ttk.Treeview(root, columns=columns, show="headings")

        for col in columns:
            self.tree.heading(col, text=col)
            self.tree.column(col, width=100)

        self.tree.pack(fill=tk.BOTH, expand=True)
        self.load_data()

    def load_data(self):
        players = self.controller.getAllPlayers()
        for player in players:
            self.tree.insert("", tk.END, values=(
                player["id"],
                player["name"],
                player["lastname"],
                player["basesalary"],
                player["bono"],
                player["finalsalary"]
            ))