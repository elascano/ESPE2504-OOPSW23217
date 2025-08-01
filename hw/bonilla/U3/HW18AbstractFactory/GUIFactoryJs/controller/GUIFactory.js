class GUIFactory {
    static getFactory() {
        // 🧠 Mover los require aquí evita la dependencia circular
        const WinFactory = require('../model/WinFactory');
        const LinuxFactory = require('../model/LinuxFactory');


        const sys = GUIFactory.readFromConfigFile("OS_TYPE");
        if (sys === 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }

    static readFromConfigFile(osType) {
        console.log("ReadFile");
        return 0; // 0 = Windows, 1 = Linux
    }

    createButton() {
        throw new Error("createButton() must be implemented");
    }

    createMenu() {
        throw new Error("createMenu() must be implemented");
    }
}

module.exports = GUIFactory;
