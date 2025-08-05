from abc import ABC, abstractmethod

class Stock(ABC):
    def __init__(self):
        self._investors = []

    def add_observer(self, investor):
        self._investors.append(investor)

    def delete_observer(self, investor):
        self._investors.remove(investor)

    def notify_observers(self, args):
        for investor in self._investors:
            investor.update(self, args)

    @abstractmethod
    def get_symbol(self):
        pass
