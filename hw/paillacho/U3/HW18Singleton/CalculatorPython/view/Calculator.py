# ec/edu/espe/view/calculator.py
# Author: Carlos Paillacho

from ec.edu.espe.model.us_tax import USTax


def main():
    tax = USTax.get_instance()

    base_price = 100.0
    total = tax.sales_total(base_price)

    print(f"Final price: ${total:.2f}")


if __name__ == "__main__":
    main()
