"""
Concrete Observer in the Observer pattern
@author Gerald Astudillo
"""

from .i_investor import IInvestor

class Investor(IInvestor):
    def __init__(self, name):
        self._name = name

    def update(self, stock, args):
        """Update method called when stock changes"""
        print(f"Notified observer {self._name}")
        if isinstance(args, str):
            print(args)
        elif isinstance(args, float):
            print(f"The price of {stock.get_symbol()} changed to: {args}")

    @property
    def name(self):
        return self._name
