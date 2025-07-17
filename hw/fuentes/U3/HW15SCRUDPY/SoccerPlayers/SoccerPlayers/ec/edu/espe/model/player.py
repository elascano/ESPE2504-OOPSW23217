from model.mongoConnection import mongoConnection
class Player:
    def __init__(self):
        self.db = mongoConnection()
    
    def getAllPlayers(self):
        cursor = self.db.find_all()
        players = []
        for p in cursor:
            players.append({
                "id": p.get("id"),
                "name": p.get("name"),
                "lastname": p.get("lastname"),
                "basesalary": p.get("basesalary"),
                "bono": p.get("bono"),
                "finalsalary": p.get("finalsalary")
            })
        return players