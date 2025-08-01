from model.Button import Button

class LinuxButton(Button):
    def paint(self):
        print(f"I'm a Linux Button: {self.caption}")