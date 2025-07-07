from tkinter import messagebox
from db_connection import DatabaseConnection
from soundmixer_menu import SoundMixerMenu
from SoundMixer import SoundMixer
from bson.objectid import ObjectId

class SoundMixerController:
    def __init__(self, user_id):
        self.db_connection = DatabaseConnection()
        self.user_id = user_id
        self.menu = SoundMixerMenu(self.on_soundmixer_create, user_id=self.user_id)
        self.menu.grab_set()

    def on_soundmixer_create(self, data):
        # Convertir user_id a ObjectId si es string
        user_id = self.user_id
        if isinstance(user_id, str):
            try:
                user_id = ObjectId(user_id)
            except Exception:
                pass

        sound_mixer = SoundMixer(
            brand=data["brand"],
            model=data["model"],
            isDigital=data["isDigital"],
            numChannels=data["numChannels"],
            price=data["price"],
            serialNumber=data["serialNumber"],
            user_id=user_id
        )
        try:
            self.db_connection.sound_mixer_collection.insert_one(sound_mixer.to_dict())
            messagebox.showinfo("Éxito", "SoundMixer guardado correctamente.")
        except Exception as e:
            messagebox.showerror("Error", f"No se pudo guardar el SoundMixer: {str(e)}")