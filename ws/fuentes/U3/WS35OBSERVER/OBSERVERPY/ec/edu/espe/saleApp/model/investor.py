from model.stock import IInvestor, Stock

class Investor(IInvestor):
    def __init__(self, name: str):
        self._name = name
        self._observer_state = ""
        self._stock = None

    def update(self, stock: Stock, arg):
        print(f"Notified observer {self._name}")

        if isinstance(arg, str):
            print(f"The symbol of {stock.get_symbol()} changed to: {arg}")
        elif isinstance(arg, float):
            print(f"The price of {stock.get_symbol()} changed to: {arg}")
