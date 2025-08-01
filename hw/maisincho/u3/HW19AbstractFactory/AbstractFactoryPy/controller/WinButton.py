from model.Button import Button

class WinButton(Button):
    def paint(self):
        print(f"I'm a WinButton: {self.caption}")