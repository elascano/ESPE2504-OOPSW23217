from model.IInvestor import IInvestor
class Investor(IInvestor):
    def __init__(self, name):
        self.name = name

    def update(self, stock, args):
        print(f"Notified Observer: {self.name}")
        if isinstance(args, str):
            print(f"The symbol of: {stock.get_symbol()} changed to: {args}")
        elif isinstance(args, float):
            print(f"The price of: {stock.get_symbol()} changed to: {args}")
