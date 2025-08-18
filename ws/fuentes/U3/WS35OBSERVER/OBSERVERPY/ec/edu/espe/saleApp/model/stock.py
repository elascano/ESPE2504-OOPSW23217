from typing import List, Any
from abc import ABC, abstractmethod

class Stock:
    def __init__(self):
        self._symbol: str = ""
        self._price: float = 0.0
        self._investors: List[IInvestor] = []

    def add_observer(self, investor):
        self._investors.append(investor)

    def delete_observer(self, investor):
        self._investors.remove(investor)

    def notify_observers(self, arg: Any):
        for investor in self._investors:
            investor.update(self, arg)

    def get_symbol(self):
        return self._symbol

    def set_symbol(self, symbol: str):
        self._symbol = symbol
        self.notify_observers(symbol)

    def get_price(self):
        return self._price

    def set_price(self, price: float):
        self._price = price
        self.notify_observers(price)


class IInvestor(ABC):
    @abstractmethod
    def update(self, stock: Stock, arg: Any):
        pass
