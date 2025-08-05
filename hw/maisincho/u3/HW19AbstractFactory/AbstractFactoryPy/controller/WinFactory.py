from controller.GUIFactory import GUIFactory
from controller.WinButton import WinButton
from model.WinMenu import WinMenu

class WinFactory(GUIFactory):
    def create_button(self):
        return WinButton()

    def create_menu(self):
        return WinMenu()