from controller.GUIFactory import GUIFactory

def main():
    factory = GUIFactory.get_factory()

    button = factory.create_button()
    button.caption = "Play"
    button.paint()

    button.caption = "Exit"
    button.paint()

if __name__ == "__main__":
    main()