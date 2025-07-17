import tkinter as tk
from model.player import Player
from controller.playerController import playerController
from view.playerView import Playerview


model = Player()
controller = playerController(model)
    
root = tk.Tk()
app = Playerview(root, controller)
root.mainloop()
    
    