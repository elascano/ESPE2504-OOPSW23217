"""
Abstract GUI Factory

@author PC
"""
from abc import ABC, abstractmethod
import platform


class GUIFactory(ABC):
    
    @staticmethod
    def get_factory():
        sys_type = GUIFactory._read_from_config_file("OS_TYPE")
        if sys_type == 0:
            from .WinFactory import WinFactory
            return WinFactory()
        else:
            from .LinuxFactory import LinuxFactory
            return LinuxFactory()
    
    @staticmethod
    def _read_from_config_file(key):
        # Simplified config reading - returns 0 for Windows, 1 for Linux
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
