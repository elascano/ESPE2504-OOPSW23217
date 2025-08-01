const Menu = require('../model/Menu');

class LinuxMenu extends Menu {
  paint() {
    console.log("I'm a LinuxMenu: " + this.caption);
  }
}

module.exports = LinuxMenu;
