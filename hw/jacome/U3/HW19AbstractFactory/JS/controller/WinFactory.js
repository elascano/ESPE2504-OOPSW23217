const GUIFactory = require('./GUIFactory');
const WinButton = require('../view/WinButton');
const WinMenu = require('../model/WinMenu');

class WinFactory extends GUIFactory {
    createButton() {
        return new WinButton();
    }

    createMenu() {
        return new WinMenu();
    }
}

module.exports = WinFactory;