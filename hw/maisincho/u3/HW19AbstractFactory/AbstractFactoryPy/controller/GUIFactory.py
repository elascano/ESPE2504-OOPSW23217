import platform
from abc import ABC, abstractmethod

class GUIFactory(ABC):
    @staticmethod
    def get_factory():
        from controller.WinFactory import WinFactory
        from controller.LinuxFactory import LinuxFactory

        sys = GUIFactory.__read_from_config_file("OS_TYPE")
        if sys == 0:
            return WinFactory()
        else:
            return LinuxFactory()

    @staticmethod
    def __read_from_config_file(key):
        os_name = platform.system().lower()
        if "win" in os_name:
            return 0
        else:
            return 1

    @abstractmethod
    def create_button(self):
        pass

    @abstractmethod
    def create_menu(self):
        pass
