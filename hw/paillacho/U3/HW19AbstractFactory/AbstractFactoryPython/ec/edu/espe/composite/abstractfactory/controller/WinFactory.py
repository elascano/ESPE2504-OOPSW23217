"""
Windows Factory implementation

@author PC
"""
from .GUIFactory import GUIFactory
from ec.edu.espe.composite.abstractfactory.model.Button import Button
from ec.edu.espe.composite.abstractfactory.model.Menu import Menu
from ec.edu.espe.composite.abstractfactory.view.WinButton import WinButton
from ec.edu.espe.composite.abstractfactory.model.WinMenu import WinMenu


class WinFactory(GUIFactory):
    
    def create_button(self):
        return WinButton()
    
    def create_menu(self):
        return WinMenu()
