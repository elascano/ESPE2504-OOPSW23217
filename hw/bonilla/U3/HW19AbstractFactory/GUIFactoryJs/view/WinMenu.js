const Menu = require('../model/Menu');

class WinMenu extends Menu {
  paint() {
    console.log("I'm a WinMenu: " + this.caption);
  }
}

module.exports = WinMenu;
