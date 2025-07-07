from pymongo import MongoClient
import urllib.parse

class MongoConnection:
    def __init__(self, user="isaac", isaac="", cluster="cluster0.xaitfht", db_name="universities_db"):
       
        password_escaped = urllib.parse.quote_plus(isaac)
        self.uri = f"mongodb+srv://{user}:{password_escaped}@{cluster}.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
        self.db_name = db_name
        self.client = None
        self.db = None

    def connect(self):
        try:
            self.client = MongoClient(self.uri)
            self.db = self.client[self.db_name]
            print(f" Conexión exitosa a MongoDB Atlas: {self.db_name}")
            return self.db
        except Exception as e:
            print(f" Error de conexión a MongoDB: {e}")
            return None

    def close(self):
        if self.client:
            self.client.close()
            print(" Conexión a MongoDB cerrada.")
