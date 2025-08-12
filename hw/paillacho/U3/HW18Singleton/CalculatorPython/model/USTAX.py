# ec/edu/espe/model/us_tax.py
# Author: Carlos Paillacho
class USTax:
    __instance = None

    def __init__(self):
        if USTax.__instance is not None:
            raise Exception("This class is a singleton! Use get_instance().")
        self.tax_value = 0.08
        USTax.__instance = self

    @staticmethod
    def get_instance():

        if USTax.__instance is None:
            USTax()
        return USTax.__instance

    def sales_total(self, base_price: float) -> float:

        return base_price + (base_price * self.tax_value)

    def get_tax_value(self) -> float:
        return self.tax_value

    def set_tax_value(self, tax_value: float):
        self.tax_value = tax_value
