"""
Observer interface for the Observer pattern
@author Gerald Astudillo
"""

from abc import ABC, abstractmethod

class IInvestor(ABC):
    @abstractmethod
    def update(self, stock, args):
        """Update method to be implemented by concrete observers"""
        pass
