from model.IBM import IBM
from model.Investor import Investor

if __name__ == "__main__":
    s = Investor("Sorros")
    b = Investor("Berkshire")
    ibm = IBM("IBM", 120.00)

    ibm.add_observer(s)
    ibm.add_observer(b)

    ibm.set_price(120.10)
    ibm.set_price(121.00)
    ibm.set_price(120.50)
    ibm.set_price(120.75)
    ibm.set_symbol("IBMTets")
