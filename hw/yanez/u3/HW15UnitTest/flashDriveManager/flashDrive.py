import tkinter as tk
from crudWindow import openCrudWindow
from calcWindow import openCalculationWindow

def mainMenu():
    menu = tk.Tk()
    menu.title("flash drive manager")
    menu.geometry("300x200")

    tk.Label(menu, text="Choose an option", font=("Arial", 14)).pack(pady=20)
    tk.Button(menu, text="CRUD", width=20, command=lambda: [menu.withdraw(), openCrudWindow(menu)]).pack(pady=10)
    tk.Button(menu, text="Calculations", width=20, command=lambda: [menu.withdraw(), openCalculationWindow(menu)]).pack(pady=10)

    menu.mainloop()

if __name__ == "__main__":
    mainMenu()
