import tkinter as tk
from tkinter import ttk, messagebox
from controller.player_controller import PlayerController
from model.soccer_player import SoccerPlayer

class SoccerApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Soccer Players CRUD")
        self.controller = PlayerController()

        self.create_widgets()
        self.populate_tree()

    def create_widgets(self):
        # Labels and entries
        tk.Label(self.root, text="ID").grid(row=0, column=0)
        tk.Label(self.root, text="Name").grid(row=1, column=0)
        tk.Label(self.root, text="Salary").grid(row=2, column=0)
        tk.Label(self.root, text="Team").grid(row=3, column=0)
        tk.Label(self.root, text="Bonus").grid(row=4, column=0)

        self.id_entry = tk.Entry(self.root)
        self.name_entry = tk.Entry(self.root)
        self.salary_entry = tk.Entry(self.root)
        self.team_entry = tk.Entry(self.root)
        self.bonus_var = tk.StringVar(value="No")
        self.bonus_combo = ttk.Combobox(self.root, textvariable=self.bonus_var, values=["Yes", "No"], state="readonly")

        self.id_entry.grid(row=0, column=1)
        self.name_entry.grid(row=1, column=1)
        self.salary_entry.grid(row=2, column=1)
        self.team_entry.grid(row=3, column=1)
        self.bonus_combo.grid(row=4, column=1)

        # Buttons
        tk.Button(self.root, text="Add", command=self.add_player).grid(row=5, column=0)
        tk.Button(self.root, text="Update", command=self.update_player).grid(row=5, column=1)
        tk.Button(self.root, text="Delete", command=self.delete_player).grid(row=5, column=2)

        # Treeview
        self.tree = ttk.Treeview(self.root, columns=("ID", "Name", "Salary", "Team", "Bonus"), show="headings")
        for col in ("ID", "Name", "Salary", "Team", "Bonus"):
            self.tree.heading(col, text=col)
            self.tree.column(col, width=100)
        self.tree.grid(row=6, column=0, columnspan=3, padx=10, pady=10)
        self.tree.bind("<Double-1>", self.load_selected_player)

    def populate_tree(self):
        for row in self.tree.get_children():
            self.tree.delete(row)
        for player in self.controller.get_all_players():
            self.tree.insert("", tk.END, values=(player.player_id, player.name, player.salary, player.team, player.bonus))

    def get_player_from_entries(self):
        try:
            salary = float(self.salary_entry.get())
        except ValueError:
            raise ValueError("Salary must be a number.")
        return SoccerPlayer(
            self.id_entry.get(),
            self.name_entry.get(),
            salary,
            self.team_entry.get(),
            self.bonus_var.get()
        )

    def add_player(self):
        try:
            player = self.get_player_from_entries()
            self.controller.add_player(player)
            self.populate_tree()
            self.clear_entries()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def update_player(self):
        try:
            player = self.get_player_from_entries()
            self.controller.update_player(player)
            self.populate_tree()
            self.clear_entries()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def delete_player(self):
        player_id = self.id_entry.get()
        try:
            self.controller.delete_player(player_id)
            self.populate_tree()
            self.clear_entries()
        except Exception as e:
            messagebox.showerror("Error", str(e))

    def load_selected_player(self, event):
        selected = self.tree.selection()
        if not selected:
            return
        values = self.tree.item(selected[0], "values")

        self.id_entry.delete(0, tk.END)
        self.name_entry.delete(0, tk.END)
        self.salary_entry.delete(0, tk.END)
        self.team_entry.delete(0, tk.END)

        self.id_entry.insert(0, values[0])
        self.name_entry.insert(0, values[1])
        self.salary_entry.insert(0, values[2])
        self.team_entry.insert(0, values[3])
        self.bonus_var.set(values[4])

    def clear_entries(self):
        self.id_entry.delete(0, tk.END)
        self.name_entry.delete(0, tk.END)
        self.salary_entry.delete(0, tk.END)
        self.team_entry.delete(0, tk.END)
        self.bonus_var.set("No")

if __name__ == "__main__":
    root = tk.Tk()
    app = SoccerApp(root)
    root.mainloop()
