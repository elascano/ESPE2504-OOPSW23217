class WinFactory extends GUIFactory {
    createButton() {
        return new WindowsButton();
    }
    
    createMenu() {
        return new WindowsMenu();
    }
}

// js/factories/LinuxFactory.js
class LinuxFactory extends GUIFactory {
    createButton() {
        return new LinuxButton();
    }
    
    createMenu() {
        return new LinuxMenu();
    }
}