from pymongo import MongoClient
from bson.objectid import ObjectId

class VinylRecordDAO:
    def __init__(self):
        uri = "mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
        client = MongoClient(uri)
        db = client["VinylSale"]
        self.collection = db["records"]

    def insert(self, record_dict):
        self.collection.insert_one(record_dict)

    def find_all(self):
        return self.collection.find()

    def find_by_title(self, title):
        return self.collection.find_one({"title": title})

    def delete_by_title(self, title):
        result = self.collection.delete_one({"title": title})
        return result.deleted_count > 0
