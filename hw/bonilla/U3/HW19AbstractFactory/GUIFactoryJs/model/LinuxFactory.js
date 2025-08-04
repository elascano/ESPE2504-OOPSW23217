const GUIFactory = require('../controller/GUIFactory');
const LinuxButton = require('../view/LinuxButton');
const LinuxMenu = require('../view/LinuxMenu');

class LinuxFactory extends GUIFactory {
  createButton() {
    return new LinuxButton();
  }

  createMenu() {
    return new LinuxMenu();
  }
}

module.exports = LinuxFactory;
