from pymongo import MongoClient

class MongoConnection:
	@staticmethod
	def get_connection():
		
		uri = "mongodb+srv://mlquiroz:Mlqh2006@cluster0.vpeg1ly.mongodb.net/"
		return MongoClient(uri)
