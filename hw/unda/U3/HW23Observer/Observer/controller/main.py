# controller/main.py

from model.stock import Stock
from model.investor import Investor

def main():
    # Crear observadores
    s = Investor("Sorros")
    b = Investor("Berkshire")

    # Crear stock y registrar observadores
    ibm = Stock("IBM", 120.00)
    ibm.add_observer(s)
    ibm.add_observer(b)

    # Cambios de estado
    ibm.set_price(120.10)
    ibm.set_price(121.00)
    ibm.set_price(120.50)
    ibm.set_price(120.75)
    ibm.set_symbol("IBMTEST")


if __name__ == "__main__":
    main()
