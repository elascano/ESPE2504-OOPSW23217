export class Wall {
  constructor() {
    this.open = false;
  }

  openWall() {
    this.open = true;
  }

  isOpen() {
    return this.open;
  }
}
