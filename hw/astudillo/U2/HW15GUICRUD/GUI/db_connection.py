import pymongo
from pymongo.errors import ConnectionFailure, ServerSelectionTimeoutError
from bson.objectid import ObjectId

class DatabaseConnection:
    def __init__(self):
        # Conexión a MongoDB Atlas
        try:
            self.client = pymongo.MongoClient("mongodb+srv://Gerald:Gerald@cluster0.ii5j1oo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
            # Verificar conexión
            self.client.admin.command('ping')
            self.db = self.client["POO"]
            self.users_collection = self.db["Users"]
            self.sound_mixer_collection = self.db["SoundMixerDb"]
            print("Conexión a MongoDB Atlas establecida correctamente.")
        except (ConnectionFailure, ServerSelectionTimeoutError) as e:
            raise ConnectionError(f"No se pudo conectar a MongoDB Atlas: {str(e)}")

    def validate_user(self, username, password):
        """
        Valida que el usuario exista y que la contraseña corresponda al mismo usuario.
        Usa el formato JSON: {_id, username, password}

        Args:
            username (str): Nombre de usuario
            password (str): Contraseña

        Returns:
            bool: True si el usuario existe y la contraseña es correcta, False en caso contrario
        """
        try:
            # Buscar el usuario que coincida tanto con el nombre de usuario como con la contraseña
            user = self.users_collection.find_one({"username": username, "password": password})
            return user is not None
        except Exception as e:
            print(f"Error al validar usuario: {str(e)}")
            return False

    def get_user_data(self, username):
        """
        Obtiene todos los datos del usuario.

        Args:
            username (str): Nombre de usuario

        Returns:
            dict: Datos del usuario o None si no existe
        """
        try:
            user = self.users_collection.find_one({"username": username})
            if user:
                # Convertir ObjectId a string para facilitar su manejo
                user['_id'] = str(user['_id'])
            return user
        except Exception as e:
            print(f"Error al obtener datos del usuario: {str(e)}")
            return None

    def get_user_by_id(self, user_id):
        """
        Obtiene el usuario por su ID.

        Args:
            user_id (str): ID del usuario en formato string

        Returns:
            dict: Datos del usuario o None si no existe
        """
        try:
            # Convertir string a ObjectId
            obj_id = ObjectId(user_id)
            user = self.users_collection.find_one({"_id": obj_id})
            if user:
                # Convertir ObjectId a string para facilitar su manejo
                user['_id'] = str(user['_id'])
            return user
        except Exception as e:
            print(f"Error al obtener usuario por ID: {str(e)}")
            return None

    def get_sound_mixer_data(self, user_id):
        print("Buscando SoundMixers para user_id:", user_id, type(user_id))
        try:
            # Asegura que user_id sea ObjectId
            if isinstance(user_id, str):
                user_id = ObjectId(user_id)
            sound_mixer_data = list(self.sound_mixer_collection.find({"user_id": user_id}))
            for doc in sound_mixer_data:
                if '_id' in doc:
                    doc['_id'] = str(doc['_id'])
                if 'user_id' in doc:
                    doc['user_id'] = str(doc['user_id'])
            return sound_mixer_data
        except Exception as e:
            print(f"Error al obtener datos del mezclador de sonido: {str(e)}")
            return []
