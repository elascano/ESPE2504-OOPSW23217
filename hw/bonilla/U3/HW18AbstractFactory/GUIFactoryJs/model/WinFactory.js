const GUIFactory = require('../controller/GUIFactory');
const WinButton = require('../view/WinButton');
const WinMenu = require('../view/WinMenu');

class WinFactory extends GUIFactory {
  createButton() {
    return new WinButton();
  }

  createMenu() {
    return new WinMenu();
  }
}

module.exports = WinFactory;
