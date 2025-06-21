from pymongo import MongoClient

def connect_to_mongo():
    uri = "mongodb+srv://Jorge:Jorge@cluster0.ny8bieg.mongodb.net/"
    client = MongoClient(uri)
    db = client["VinylRecords"]
    return db["records"]