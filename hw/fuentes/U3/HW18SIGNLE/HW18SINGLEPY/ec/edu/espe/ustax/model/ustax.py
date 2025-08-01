import json
import os

class USTax:
    __instance = None

    def __new__(cls):
        if cls.__instance is None:
            cls.__instance = super(USTax, cls).__new__(cls)
            cls.__instance.initialize()
        return cls.__instance

    def initialize(self):
        self.taxRate = self.loadTaxFromJsonConfig()

    def loadTaxFromJsonConfig(self):
        defaultRate = 0.15
        config_path = os.path.join(os.path.dirname(__file__), "config.json")
        try:
            with open(config_path, 'r') as file:
                data = json.load(file)
                return float(data.get("taxRate", defaultRate))
        except Exception as e:
            print(f"Error loading config.json: {e}")
            return defaultRate

    def CalculatesalesTotal(self, baseAmount):
        return baseAmount + (baseAmount * self.taxRate)

    def getTaxRate(self):
        return self.taxRate
