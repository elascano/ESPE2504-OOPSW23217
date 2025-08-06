from model.ustax import USTax

def main():
    tax = USTax()
    price = float(input("Enter the product price: "))
    total_price = tax.CalculatesalesTotal(price)
    print(f"The total price with tax is: {total_price}")

if __name__ == "__main__":
    main()