const GUIFactory = require('./GUIFactory');
const LinuxButton = require('../view/LinuxButton');
const LinuxMenu = require('../model/LinuxMenu');

class LinuxFactory extends GUIFactory {
    createButton() {
        return new LinuxButton();
    }

    createMenu() {
        return new LinuxMenu();
    }
}

module.exports = LinuxFactory;