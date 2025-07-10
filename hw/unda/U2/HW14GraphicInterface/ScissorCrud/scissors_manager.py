from pymongo import MongoClient

# Conexión a MongoDB local
client = MongoClient("mongodb+srv://mjunda1:MateoUndaJM05@cluster0.7yle2fx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
db = client["ScissorsDB"]
collection = db["scissors"]

# Funciones CRUD
def create_scissor(data):
    collection.insert_one(data)

def read_scissors():
    return list(collection.find())

def update_scissor(scissor_id, new_data):
    collection.update_one({"_id": scissor_id}, {"$set": new_data})

def delete_scissor(scissor_id):
    collection.delete_one({"_id": scissor_id})
