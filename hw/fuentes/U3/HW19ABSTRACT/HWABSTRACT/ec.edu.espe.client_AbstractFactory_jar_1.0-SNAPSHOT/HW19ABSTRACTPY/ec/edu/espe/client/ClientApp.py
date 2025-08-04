from model.GUIFactory import GUIFactory

def main():
    aFactory = GUIFactory.getFactory()
    aButton = aFactory.createButton()
    aButton.caption = "Play"
    aButton.paint()

if __name__ == "__main__":
    main()
