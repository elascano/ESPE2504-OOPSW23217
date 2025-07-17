class playerController:
    def __init__(self, model):
        self.model = model
        
    def getAllPlayers(self):
        return self.model.getAllPlayers()    