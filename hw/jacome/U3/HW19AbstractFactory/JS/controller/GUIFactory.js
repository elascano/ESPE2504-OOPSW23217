class GUIFactory {
    static getFactory() {
        const os = require('os').platform().toLowerCase();
        if (os.includes('win')) {
            return new (require('./WinFactory'))();
        } else {
            return new (require('./LinuxFactory'))();
        }
    }

    createButton() {
        throw new Error("Abstract method createButton() must be implemented");
    }

    createMenu() {
        throw new Error("Abstract method createMenu() must be implemented");
    }
}

module.exports = GUIFactory;