from model.GUIFactory import GUIFactory
from model.LinuxButton import LinuxButton
from model.LinuxMenu import LinuxMenu

class LinuxFactory(GUIFactory):
    def createButton(self):
        return LinuxButton()

    def createMenu(self):
        return LinuxMenu()
