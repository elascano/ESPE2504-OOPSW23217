class Egg: 
    def __init__(self, id=0):
        self._id = id

    def get_id(self):
        return self._id

    def set_id(self, id):
        self._id = id

    def __str__(self):
        return f"Egg(id={self._id})"
