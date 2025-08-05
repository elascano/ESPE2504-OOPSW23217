from controller.GUIFactory import GUIFactory
from controller.LinuxButton import LinuxButton
from model.LinuxMenu import LinuxMenu

class LinuxFactory(GUIFactory):
    def create_button(self):
        return LinuxButton()

    def create_menu(self):
        return LinuxMenu()