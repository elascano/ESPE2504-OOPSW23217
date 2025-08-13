"""
Concrete Subject in the Observer pattern
@author Carlos Paillacho
"""

from .stock import Stock


class IBM(Stock):
    def __init__(self, symbol, price):
        super().__init__()
        self._symbol = symbol
        self._price = price

    def get_price(self):
        return self._price

    def set_price(self, price):
        self._price = price
        self.notify_observers(float(price))

    def get_symbol(self):
        return self._symbol

    def set_symbol(self, symbol):
        old_symbol = self._symbol
        self._symbol = symbol
        self.notify_observers(f"Symbol changed from {old_symbol} to {symbol}")
