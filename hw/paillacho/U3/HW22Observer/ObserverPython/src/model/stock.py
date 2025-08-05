"""
Subject (Observable) in the Observer pattern
@author Gerald Astudillo
"""

from abc import ABC, abstractmethod

class Stock(ABC):
    def __init__(self):
        self._symbol = None
        self._price = None
        self._investors = []

    def add_observer(self, investor):
        """Add an observer to the list"""
        self._investors.append(investor)

    def delete_observer(self, investor):
        """Remove an observer from the list"""
        if investor in self._investors:
            self._investors.remove(investor)

    def notify_observers(self, args):
        """Notify all observers about changes"""
        for investor in self._investors:
            investor.update(self, args)

    @abstractmethod
    def get_symbol(self):
        """Abstract method to get symbol"""
        pass

    @abstractmethod
    def get_price(self):
        """Abstract method to get price"""
        pass
