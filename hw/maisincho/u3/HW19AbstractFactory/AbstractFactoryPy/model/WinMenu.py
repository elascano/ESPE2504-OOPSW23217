from model.Menu import Menu

class WinMenu(Menu):
    def paint(self):
        print(f"I'm a WinMenu: {self.caption}")
