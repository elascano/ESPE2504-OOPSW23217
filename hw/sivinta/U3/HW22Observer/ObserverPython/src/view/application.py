"""
Main application class to demonstrate the Observer pattern
@author Gerald Astudillo
"""

import sys
import os

# Add the src directory to the Python path
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..'))

from model.ibm import IBM
from model.investor import Investor

class Application:
    @staticmethod
    def main():
        # Create investors (observers)
        s = Investor("Sorros")
        b = Investor("Berkshire")

        # Create IBM stock (subject)
        ibm = IBM("IBM", 120.00)
        ibm.add_observer(s)
        ibm.add_observer(b)

        # Change prices and notify observers
        ibm.set_price(120.10)
        ibm.set_price(121.00)
        ibm.set_price(120.50)
        ibm.set_price(120.75)
        ibm.set_symbol("IBMTEST")

if __name__ == "__main__":
    Application.main()
