from ustax import USTax

class Calculator:
    
    @staticmethod
    def main():
        tax = USTax.get_instance()
        print(f"Sales Total: {tax.sales_total()}")

if __name__ == "__main__":
    Calculator.main()
