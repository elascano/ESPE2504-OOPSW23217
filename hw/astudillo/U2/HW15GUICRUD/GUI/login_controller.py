from tkinter import messagebox
from MenuLogin import LoginMenu
from soundmixer_menu import SoundMixerMenu
from db_connection import DatabaseConnection
from soundmixer_controller import SoundMixerController
import traceback

class LoginController:
    def __init__(self, root):
        try:
            self.db_connection = DatabaseConnection()
            self.menu = LoginMenu(root, self.verificar_login)
            self.menu.grab_set()  # Hace modal la ventana de login
        except ConnectionError as e:
            messagebox.showerror("Error de conexión", str(e))

    def verificar_login(self, usuario, password):
        if not usuario or not password:
            messagebox.showwarning("Campos vacíos", "Por favor, complete todos los campos")
            return
        try:
            user_data = self.db_connection.get_user_data(usuario)
            if self.db_connection.validate_user(usuario, password):
                self.menu.destroy()
                SoundMixerController(user_data['_id'])
            else:
                messagebox.showerror("Error", "Usuario o contraseña incorrectos")
        except Exception as e:
            print(f"Error en verificar_login: {traceback.format_exc()}")
            messagebox.showerror("Error", f"Error al verificar credenciales: {str(e)}")

    def on_soundmixer_create(self, data):
        print("Datos del SoundMixer:", data)

