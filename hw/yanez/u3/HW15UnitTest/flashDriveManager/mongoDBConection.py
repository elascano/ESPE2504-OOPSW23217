from pymongo import MongoClient

def getCollection():
    client = MongoClient("mongodb://localhost:27017/")
    db = client["wargame"]
    return db["flashdrive"]
