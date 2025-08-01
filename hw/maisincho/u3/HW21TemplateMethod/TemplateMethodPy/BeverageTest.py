from model.Tea import Tea
from model.Coffee import Coffee

def main():
    tea = Tea()
    coffee = Coffee()

    print("Tea..")
    tea.prepare_recipe()

    print("Coffee..")
    coffee.prepare_recipe()

if __name__ == "__main__":
    main()
