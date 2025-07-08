import tkinter as tk
from tkinter import ttk

class LoginMenu(tk.Toplevel):
    def __init__(self, master, on_login_callback):
        super().__init__(master)
        self.title("Login")
        self.geometry("300x150")
        self.resizable(False, False)

        ttk.Label(self, text="Usuario:").grid(row=0, column=0, pady=10, padx=10)
        self.user_entry = ttk.Entry(self)
        self.user_entry.grid(row=0, column=1, padx=10)

        ttk.Label(self, text="Contraseña:").grid(row=1, column=0, padx=10)
        self.pass_entry = ttk.Entry(self, show="*")
        self.pass_entry.grid(row=1, column=1, padx=10)

        self.login_button = ttk.Button(self, text="Iniciar sesión", command=self._on_login)
        self.login_button.grid(row=2, column=0, columnspan=2, pady=20)

        self.on_login_callback = on_login_callback

    def _on_login(self):
        usuario = self.user_entry.get()
        password = self.pass_entry.get()
        self.on_login_callback(usuario, password)