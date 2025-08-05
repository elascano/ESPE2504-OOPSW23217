from pymongo import MongoClient
from model.University import University  

class MongoConnection:
    def __init__(self):
        user = "isaac"
        password = "isaac"
        cluster = "cluster0.xaitfht"
        uri = f"mongodb+srv://{user}:{password}@{cluster}.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
        self.client = MongoClient(uri)
        self.db = self.client["University"]  

    def get_universities(self):
        collection = self.db["university"]
        documents = collection.find()
        universities = []
        for doc in documents:
            u = University(
                doc.get("id"),
                doc.get("name"),
                doc.get("monthlyIncome"),
                doc.get("numberOfStudent")
            )
            universities.append(u)
        return universities

    def close(self):
        self.client.close()