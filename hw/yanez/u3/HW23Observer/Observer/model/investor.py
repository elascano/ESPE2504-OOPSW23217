# model/investor.py

class IInvestor:
    def update(self, stock, data):
        pass


class Investor(IInvestor):
    def __init__(self, name):
        self.name = name

    def update(self, stock, data):
        print(f"Notified observer {self.name}")
        if isinstance(data, str):
            print(f"The symbol of {stock.symbol} changed to: {data}")
        elif isinstance(data, float):
            print(f"The price of {stock.symbol} changed to: {data}")
