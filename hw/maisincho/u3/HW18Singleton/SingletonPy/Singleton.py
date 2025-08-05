from controller.Calculator import Calculator
from model.USTax import USTax

def main():
    calculator = Calculator()

    subtotal = 10.0
    total = calculator.sales_total(subtotal)
    print(f"The total is --> ${total}")

    USTax.get_instance().set_tax_percentage(0.15)
    total = calculator.sales_total(subtotal)
    print(f"The total with 15% tax is --> ${total}")

if __name__ == "__main__":
    main()