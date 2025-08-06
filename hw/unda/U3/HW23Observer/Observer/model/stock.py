# model/stock.py

class Stock:
    def __init__(self, symbol, price):
        self.symbol = symbol
        self.price = price
        self._observers = []

    def add_observer(self, investor):
        self._observers.append(investor)

    def remove_observer(self, investor):
        self._observers.remove(investor)

    def notify_observers(self, data):
        for investor in self._observers:
            investor.update(self, data)

    def set_price(self, new_price):
        self.price = new_price
        self.notify_observers(new_price)

    def set_symbol(self, new_symbol):
        self.symbol = new_symbol
        self.notify_observers(new_symbol)
