"""
Linux Factory implementation

@author PC
"""
from .GUIFactory import GUIFactory
from ec.edu.espe.composite.abstractfactory.model.Button import Button
from ec.edu.espe.composite.abstractfactory.model.Menu import Menu
from ec.edu.espe.composite.abstractfactory.view.LinuxButton import LinuxButton
from ec.edu.espe.composite.abstractfactory.model.LinuxMenu import LinuxMenu


class LinuxFactory(GUIFactory):
    
    def create_button(self):
        return LinuxButton()
    
    def create_menu(self):
        return LinuxMenu()
