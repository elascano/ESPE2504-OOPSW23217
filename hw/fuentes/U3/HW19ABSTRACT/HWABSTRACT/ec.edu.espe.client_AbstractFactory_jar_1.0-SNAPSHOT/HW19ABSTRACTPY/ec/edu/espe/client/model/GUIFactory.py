import platform

class GUIFactory:
    @staticmethod
    def getFactory():
        sys = GUIFactory.__readFromConfigFile("OS_TYPE")
        if sys == 0:
            from model.WinFactory import WinFactory
            return WinFactory()
        else:
            from model.LinuxFactory import LinuxFactory
            return LinuxFactory()

    @staticmethod
    def __readFromConfigFile(key):
        os_name = platform.system().lower()
        if "win" in os_name:
            return 0
        else:
            return 1

    def createButton(self):
        raise NotImplementedError

    def createMenu(self):
        raise NotImplementedError
