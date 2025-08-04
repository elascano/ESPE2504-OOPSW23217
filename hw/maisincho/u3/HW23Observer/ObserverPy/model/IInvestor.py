from abc import ABC, abstractmethod

class IInvestor(ABC):
    @abstractmethod
    def update(self, stock, args):
        pass
