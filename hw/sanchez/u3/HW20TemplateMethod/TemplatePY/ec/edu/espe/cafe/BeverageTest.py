from model.Tea import Tea
from model.Coffee import Coffee

def main():
    tea = Tea()
    coffee = Coffee()

    print("\nMaking tea...")
    tea.prepareRecipe()

    print("\nMaking coffee...")
    coffee.prepareRecipe()

if __name__ == "__main__":
    main()
