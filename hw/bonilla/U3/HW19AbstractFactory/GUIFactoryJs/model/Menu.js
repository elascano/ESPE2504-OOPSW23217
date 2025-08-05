class Menu {
  constructor() {
    this.caption = '';
  }

  paint() {
    throw new Error('paint() must be implemented');
  }
}

module.exports = Menu;
