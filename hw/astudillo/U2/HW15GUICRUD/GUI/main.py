import tkinter as tk
from tkinter import messagebox
import sys
import importlib.util
from soundmixer_menu import SoundMixerMenu

# Verificar si pymongo está instalado correctamente
def check_module(module_name):
    """Verifica si un módulo está instalado y disponible."""
    module_spec = importlib.util.find_spec(module_name)
    return module_spec is not None

# Verificar dependencias
required_modules = ['pymongo']
missing_modules = []

for module in required_modules:
    if not check_module(module):
        missing_modules.append(module)

if missing_modules:
    root = tk.Tk()
    root.withdraw()
    messagebox.showerror("Dependencias faltantes", 
                       f"Por favor, instala las siguientes dependencias:\n\npip install {' '.join(missing_modules)}")
    root.destroy()
    sys.exit(1)

# Importar módulos después de verificar
import pymongo
from pymongo.errors import ConnectionFailure, ServerSelectionTimeoutError
from login_controller import LoginController
from db_connection import DatabaseConnection

def test_db_connection():
    """Prueba la conexión a la base de datos y muestra información"""
    try:
        db = DatabaseConnection()
        print("\n=== Información de la base de datos ===")
        print(f"Base de datos: {db.db.name}")
        collections = db.db.list_collection_names()
        print(f"Colecciones disponibles: {collections}")

        # Contar usuarios en la colección
        user_count = db.users_collection.count_documents({})
        print(f"Número de usuarios en la colección: {user_count}")

        if '--test' in sys.argv:
            # Solo mostrar la información para depuración
            return False
        return True
    except pymongo.errors.ConnectionFailure as e:
        print(f"Error de conexión a la base de datos: {str(e)}")
        # Asegurar que existe una ventana Tk antes de mostrar el mensaje
        root = tk.Tk()
        root.withdraw()
        messagebox.showerror("Error de conexión", 
                             f"No se pudo conectar a la base de datos: {str(e)}\n\n" +
                             "Verifique su conexión a internet y que las credenciales sean correctas.")
        root.destroy()
        return False
    except Exception as e:
        print(f"Error al conectar a la base de datos: {str(e)}")
        # Asegurar que existe una ventana Tk antes de mostrar el mensaje
        root = tk.Tk()
        root.withdraw()
        messagebox.showerror("Error de conexión", 
                             f"No se pudo conectar a la base de datos: {str(e)}\n\n" +
                             "Verifique su conexión a internet y que las credenciales sean correctas.")
        root.destroy()
        return False

if __name__ == "__main__":
    try:
        if test_db_connection():
            # Iniciar el controlador de login
            print("Conexión a la base de datos exitosa. Iniciando aplicación...")
            root = tk.Tk()
            root.withdraw()
            LoginController(root)
            root.mainloop()
    except Exception as e:
        root = tk.Tk()
        root.withdraw()
        messagebox.showerror("Error", f"Ocurrió un error: {str(e)}")
        root.destroy()