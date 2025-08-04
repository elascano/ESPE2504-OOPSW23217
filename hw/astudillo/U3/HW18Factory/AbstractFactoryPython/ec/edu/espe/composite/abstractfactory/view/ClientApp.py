"""
Client Application

@author PC
"""
from ec.edu.espe.composite.abstractfactory.controller.GUIFactory import GUIFactory
from ec.edu.espe.composite.abstractfactory.model.Button import Button
from ec.edu.espe.composite.abstractfactory.model.Menu import Menu


class ClientApp:
    
    @staticmethod
    def main():
        a_factory = GUIFactory.get_factory()
        
        a_button = a_factory.create_button()
        a_button.caption = "Play"
        a_button.paint()
        
        a_menu = a_factory.create_menu()
        a_menu.caption = "File"
        a_menu.paint()


if __name__ == "__main__":
    ClientApp.main()
