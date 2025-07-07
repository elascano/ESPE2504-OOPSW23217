class SoundMixer:
    def __init__(self, brand, model, isDigital, numChannels, price, serialNumber, user_id=None):
        self.brand = brand
        self.model = model
        self.isDigital = isDigital
        self.numChannels = numChannels
        self.price = price
        self.serialNumber = serialNumber
        self.user_id = user_id

    def to_dict(self):
        data = {
            "brand": self.brand,
            "model": self.model,
            "isDigital": self.isDigital,
            "numChannels": self.numChannels,
            "price": self.price,
            "serialNumber": self.serialNumber
        }
        if self.user_id:
            data["user_id"] = self.user_id
        return data