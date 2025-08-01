from model.GUIFactory import GUIFactory
from model.WinButton import WinButton
from model.WinMenu import WinMenu

class WinFactory(GUIFactory):
    def createButton(self):
        return WinButton()

    def createMenu(self):
        return WinMenu()
